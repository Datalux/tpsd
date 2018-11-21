/* Realizzare due thread A e B, che stampano rispettivamente
i numeri pari e i numeri dispari (da 1 a 100). */

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
#include <pthread.h>

int n;
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

void func_tA()
{
	while(1){
		pthread_mutex_lock(&mutex);
		
		if(n == 100){
			pthread_mutex_unlock(&mutex);
			pthread_exit(NULL);
		} 
		else if(n%2 != 0){
			n++;
			printf("[tA] n = %d\n",n);
		}

		pthread_mutex_unlock(&mutex);
	}
}

void func_tB()
{
	while(1){
		pthread_mutex_lock(&mutex);

		if(n == 99) {
			pthread_mutex_unlock(&mutex);
			pthread_exit(NULL);

		}
		else if(n%2 == 0){
			n++;
			printf("[tB] n = %d\n",n);
		}

		pthread_mutex_unlock(&mutex);
	}

}

int main(int argc, char **argv)
{

	n = 0;

	pthread_t tA, tB;

	pthread_create(&tA, NULL, (void *) func_tA, NULL);
	pthread_create(&tB, NULL, (void *) func_tB, NULL);

	pthread_join(tA, NULL);
	pthread_join(tB, NULL);

	return 0;
}