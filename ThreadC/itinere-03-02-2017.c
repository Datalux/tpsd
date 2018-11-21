#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <time.h>

int n;
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

void func_t0(void)
{
	int counter = 0;

	while(1){
		usleep(200000);
		int value = rand() % 10;

		if((value%2) != 0) 
			value++;

		pthread_mutex_lock(&mutex);
		printf("[t0] n = %d\n",n);
		n += value;
		pthread_mutex_unlock(&mutex);

		counter++;

		if(counter >= 10 && (n%2 == 0)){
			printf("[t0] termino... counter = %d, random_value = %d\n", counter, value);
			pthread_exit(NULL);
		}
		else if(counter >= 1000){
			printf("[t0] termino... counter = %d, random_value = %d\n", counter, value);
			pthread_exit(NULL);
		}
	}
}

void func_tE(void)
{
	int counter = 0;

	while(1){
		usleep(200000);
		int value = rand() % 10;

		if((value%2) == 0) 
			value++;

		pthread_mutex_lock(&mutex);
		printf("[tE] n = %d\n",n);		
		n += value;
		pthread_mutex_unlock(&mutex);

		counter++;

		if(counter >= 10 && (n%2 != 0)){
			printf("[tE] termino... counter = %d, random_value = %d\n", counter, value);
			pthread_exit(NULL);
		}
		else if(counter >= 1000){
			printf("[tE] termino... counter = %d, random_value = %d\n", counter, value);
			pthread_exit(NULL);
		}
	}

}

int main(int argc, char **argv)
{
	srand(time(NULL));
	n = 0;

	pthread_t t0, tE;

	pthread_create(&t0, NULL, (void *) func_t0, NULL);
	pthread_create(&tE, NULL, (void *) func_tE, NULL);

	pthread_join(t0, NULL);
	pthread_join(tE, NULL);

	return 0;
}