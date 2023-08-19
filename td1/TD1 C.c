#include <stdio.h>
#include <stdlib.h>
#include <math.h>
struct botas{
    int tamanho;
    char lado;
};
typedef struct botas Botas;

int AvaliarBotas(int n, Botas pares[]){
    int cont = 0;
    if(n >= 2 && n <= pow(10, 4) && n%2 == 0){
        for(int i = 0; i < n; i++){
            if(pares[i].tamanho >= 30 && pares[i].tamanho <= 60){
                if(pares[i].lado == 'D' || pares[i].lado == 'E'){
                    cont++;
                    
                }
            }
        }
    }
    return cont;
}
int FazerPares(int n, Botas pares[]){
    for(int i = 0; i < n; i++){
        printf("Digite o tamanho da bota: ");
        scanf("%i", &pares[i].tamanho);
        printf("Digite 'E' para esquerdo e 'D' para direito: ");
        scanf(" %c", &pares[i].lado);
    }
    if(AvaliarBotas(n, pares) != n){
        printf("Alguma informação não está cumprindo as seguintes restrições: '2<=N<=10000, N é par, 30<=M<=60, L pertence a {D, E}'. Por favor tente novamente digitando dados válidos!");
    }else{
        int cont = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(pares[i].tamanho == pares[j].tamanho){
                    if(pares[i].lado == 'D' && pares[j].lado == 'E' || pares[i].lado == 'E' && pares[j].lado == 'D'){
                        cont++;
                    }
                }
            }
        }
        printf("o numero de pares é: %i", cont);
    }
}

int main (){
    int n;
    printf("Digite a quntidade de botas: ");
    scanf("%i", &n);
    Botas pares[n];
    FazerPares(n, pares);
}
