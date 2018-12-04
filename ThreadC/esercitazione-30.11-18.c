#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <time.h>
#include <string.h>

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
int share;

void fun_tI()
{
	for(int i = 0; i < 1000; i++){
		usleep(100 * 1000);
		int v = rand() % 10;
		pthread_mutex_lock(&mutex);
		share += v;
		printf("[tI] share = %d\n", share);
		if(share > 150){
			printf("[tI] EXIT\n");
			pthread_mutex_unlock(&mutex);
			pthread_exit(NULL);
		}
		pthread_mutex_unlock(&mutex);		
	}
}

void fun_tD()
{
	for(int i = 0; i < 1000; i++){
		usleep(300 * 1000);
		int v = rand() % 10;
		pthread_mutex_lock(&mutex);
		share -= v;
		printf("[tD] share = %d\n", share);
		if(share < 80){
			printf("[tI] EXIT\n");
			pthread_mutex_unlock(&mutex);
			pthread_exit(NULL);
		}
		pthread_mutex_unlock(&mutex);
	}

}

int main()
{
	share = 100;
	srand(time(NULL));

	pthread_t tI, tD;

	pthread_create(&tI, NULL, (void *) fun_tI, NULL);
	pthread_create(&tD, NULL, (void *) fun_tD, NULL);

	pthread_join(tI, NULL);
	pthread_join(tD, NULL);



}