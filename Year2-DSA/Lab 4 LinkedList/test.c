#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <sys/types.h>

int main() {
    pid_t pid;
    int i;
    for (i = 0; i < 3; i++) {
        pid = fork();
        if (pid == 0) {
            if (i == 0) {
                execlp("echo", "echo", "g m");
                printf("OK\n");
            } else if (i == 1) {
                execlp("echo", "echo", "g a");
                printf("OK\n");
            } else {
                execlp("echo", "echo", "g n");
                printf("OK\n");
            }
        }
    }
    while (wait(NULL) != -1);
    printf("gb\n");
    return 0;
}