# Sobre o projeto Invisibility Cloak

Este projeto simula uma "capa de invisibilidade" reproduzindo uma espécie de efeito chroma key, utilizando conceitos básicos de visão computacional e processamento de imagens. Desenvolvido em linguagem de programação Java.

## Como funciona

O programa acessa a câmera do computador e aguarda o usuário apertar a tecla espaço,
após isso é feita uma captura da imagem, como se fosse tirada uma "foto", que irá sobrepor cada vez que um pano verde for colocado em frente a câmera. É importante que o fundo seja uma foto vazia, apenas com o que deverá ser mostrado no lugar do pano verde,
abaixo está um exemplo de fundo que será usado ao apertar a tecla "espaço".

![Fundo-mantido](https://github.com/user-attachments/assets/a6b68250-c33f-4965-b85c-c22c8006aafe)

Para isto, estou utilizando esta peça de roupa:

![Pano-real](https://github.com/user-attachments/assets/fdb07b8b-1c0b-4d31-ae83-d3ee7a4904e1)

Abaixo segue um exemplo do programa em funcionamento, fazendo a remoção da cor verde em tempo real e sobrepondo com o fundo capturado no início, sendo assim este seria o resultado final:

![Verde-removido](https://github.com/user-attachments/assets/87b98103-6030-4f72-a5b1-31265dab6245)

Vale ressaltar que o intuito do programa é não apenas remover a cor verde, mas de fato simular uma capa de invisibilidade. Note que, apesar de eu estar atrás da roupa segurando a mesma e apontando para a câmera, a única coisa que aparece é o fundo capturado
e eu simplesmente desapareço como um truque de mágica, junto com a peça de roupa.

# Tecnologias utilizadas

- Java
- JavaCV
- Maven

Um programa como este seria mais facilmente desenvolvido em linguagem Python, utilizando a biblioteca OpenCV que é uma das melhores opções para se trabalhar com visão computacional. Porém eu decidi me desafiar um pouco mais e testar os limites da linguagem Java,
após um breve levantamento de requisitos descobri que para atingir este objetivo eu teria que usar JavaCV, que funciona como um wrapper da biblioteca OpenCV, porém específico para desenvolvimento em Java.<br>
<br>
O repositório do JavaCV pode ser acessado [aqui](https://github.com/bytedeco/javacv)

# Código fonte
[Invisibility cloak](https://github.com/pgdinelli/InvisibilityCloak/blob/main/src/main/java/com/pgdinelli/Main.java)

# Autor
Paulo Guilherme Souza Dinelli<br>
Linkedin: [https://www.linkedin.com/in/paulodinelli/](https://www.linkedin.com/in/paulodinelli/)
