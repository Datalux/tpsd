#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>
#include <ctype.h>
#include <time.h>
#include <unistd.h>

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
int x = 0;

void func_hit(void *arg)
{
	int hit = 0;
	while(1){
		usleep(rand() % 50000 + 1);
		pthread_mutex_lock(&mutex);

		if(x > 500){
			fprintf(stdout, "hit%s = %d \n",(char *) arg, hit);
			pthread_mutex_unlock(&mutex);
			pthread_exit(NULL);
		} else {
			x++;
			hit++;
			pthread_mutex_unlock(&mutex);
		}
	}
}

int main(int arg, char **argv)
{
	pthread_t tA, tB;

	srand(time(NULL));

	pthread_create(&tA, NULL, (void *)&func_hit, (void *) "A");
	pthread_create(&tB, NULL, (void *)&func_hit, (void *) "B");

	pthread_join(tA, NULL);
	pthread_join(tB, NULL);

	exit(0);
}