#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
#include <string.h>
#include <pthread.h>

#define MAX_WIN 2

int pos;
int vittorie_tp0, vittorie_tp1;

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t cond = PTHREAD_COND_INITIALIZER;

void func_tp0()
{
	while(1){
		int recuepero = rand() % 4;
		int forza = rand() % 6;
		sleep(recuepero);
		
		pthread_mutex_lock(&mutex);

		if(vittorie_tp1 == MAX_WIN || vittorie_tp0 == MAX_WIN){
			pthread_mutex_unlock(&mutex);
			pthread_exit(NULL);
		}

		if(pos >= 10){
			vittorie_tp1++;
			printf("\nT1 WIN!\n\n");
			pos = 0;
			pthread_cond_signal(&cond);
		} else {
			pos -= forza;
			printf("[TP0] pos = %d\n", pos);
			if(pos <= -10){
				pthread_cond_wait(&cond, &mutex);
			}
		}
		pthread_mutex_unlock(&mutex);
	}
}

void func_tp1()
{
	while(1){
		int recuepero = rand() % 4;
		int forza = rand() % 6;
		sleep(recuepero);

		pthread_mutex_unlock(&mutex);

		if(vittorie_tp0 == MAX_WIN || vittorie_tp1 == MAX_WIN){
			pthread_mutex_unlock(&mutex);
			pthread_exit(NULL);
		}

		if(pos <= -10){
			vittorie_tp0++;
			printf("\nT0 WIN!\n\n");
			pos = 0;
			pthread_cond_signal(&cond);
		} else {
			pos += forza;
			printf("[TP1] pos = %d\n", pos);
			if(pos >= 10){
				pthread_cond_wait(&cond, &mutex);
			}
		}
		pthread_mutex_unlock(&mutex);
	}
}





int main()
{

	pos = vittorie_tp1 = vittorie_tp0 = 0;

	pthread_t tp0, tp1;

	pthread_create(&tp0, NULL, (void *) func_tp0, NULL);
	pthread_create(&tp1, NULL, (void *) func_tp1, NULL);

	pthread_join(tp0, NULL);
	pthread_join(tp1, NULL);

	if(vittorie_tp0 > vittorie_tp1)
		printf("TP0 WIN with %d victories\n", vittorie_tp0);
	else
		printf("TP1 WIN with %d victories\n", vittorie_tp1);

	return 0;
}