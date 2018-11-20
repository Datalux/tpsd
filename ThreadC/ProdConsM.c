#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <time.h>
#include <ctype.h>

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t cp1 = PTHREAD_COND_INITIALIZER;
pthread_cond_t cp2 = PTHREAD_COND_INITIALIZER;

int m;

void func_p1(void)
{
	while(1){
		pthread_mutex_lock(&mutex);
		if(m <= 5){
			pthread_cond_signal(&cp1);
			m = (rand() % 10) + 1;
			fprintf(stdout, "[p1] m = %d\n", m);
		} else {
			pthread_cond_wait(&cp2, &mutex);
		}
		pthread_mutex_unlock(&mutex);
	}
}

void func_p2(void)
{
	while(1){
		pthread_mutex_lock(&mutex);
		if(m >= 6){
			pthread_cond_signal(&cp2);
			m = (rand() % 10) + 1;
			fprintf(stdout, "[p2] m = %d\n", m);
		} else {
			pthread_cond_wait(&cp1, &mutex);
		}
		pthread_mutex_unlock(&mutex);
	}

}

int main(int argc, char **argv)
{
	pthread_t p1, p2;
	srand(time(NULL));

	m = (rand() % 10) + 1;

	pthread_create(&p1, NULL, (void *) func_p1, NULL);
	pthread_create(&p2, NULL, (void *) func_p2, NULL);

	pthread_join(p1, NULL);
	pthread_join(p2, NULL);

	exit(0);
}