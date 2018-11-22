#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <time.h>

int n;
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

void func_tE(void)
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
			printf("[tE] termino... counter = %d, random_value = %d\n", counter, value);
			pthread_exit(NULL);
		}
		else if(counter >= 1000){
			printf("[tE] termino... counter = %d, random_value = %d\n", counter, value);
			pthread_exit(NULL);
		}
	}
}

void func_tO(void)
{
	int counter = 0;

	while(1){
		usleep(200000);
		int value = rand() % 10;

		if((value%2) == 0) 
			value++;

		pthread_mutex_lock(&mutex);
		printf("[tO] n = %d\n",n);		
		n += value;
		pthread_mutex_unlock(&mutex);

		counter++;

		if(counter >= 10 && (n%2 != 0)){
			printf("[tO] termino... counter = %d, random_value = %d\n", counter, value);
			pthread_exit(NULL);
		}
		else if(counter >= 1000){
			printf("[tO] termino... counter = %d, random_value = %d\n", counter, value);
			pthread_exit(NULL);
		}
	}

}

int main(int argc, char **argv)
{
	srand(time(NULL));
	n = 0;

	pthread_t tO, tE;

	pthread_create(&tO, NULL, (void *) func_tO, NULL);
	pthread_create(&tE, NULL, (void *) func_tE, NULL);

	pthread_join(tO, NULL);
	pthread_join(tE, NULL);

	return 0;
}