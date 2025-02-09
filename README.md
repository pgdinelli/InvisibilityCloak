# Sobre o projeto Invisibility Cloak

Este projeto simula uma "capa de invisibilidade" reproduzindo uma espécie de efeito chroma key, utilizando conceitos básicos de visão computacional e processamento de imagens. Desenvolvido em linguagem de programação Java.

## Como funciona
O programa acessa a câmera do computador para capturar imagens em tempo real, ao iniciar o programa é esperado que o usuário aperte a tecla "espaço" para que seja capturado uma imagem de fundo. Ao capturar esta imagem se inicia o processo de remoção de cor, onde o programa irá detectar os pixels da imagem que contém a cor verde e irá sobrepor com a imagem de fundo que foi capturada no início.
Para fazer a detecção de cor foi utilizado um intervalo de valores em formato HSV (Hue, Saturation, Value) correspondentes aos tons mais claros de verde, em vez do formato RGB (Red, Green, Blue). Esta conversão para HSV torna mais fácil a manipulação e detecção da cor, pois a iluminação ambiente é um fator que deve ser levado em consideração e também pode ser especificado dentro deste intervalo.
É importante que o fundo seja uma foto vazia, apenas com o que deverá ser mostrado no lugar do pano verde,
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
após um breve levantamento de requisitos descobri que para atingir este objetivo eu teria que usar JavaCV, que funciona como uma classe wrapper da biblioteca OpenCV, porém específico para desenvolvimento em Java.<br>
<br>
O repositório do JavaCV pode ser acessado [aqui](https://github.com/bytedeco/javacv)

# Código fonte
[Invisibility cloak](https://github.com/pgdinelli/InvisibilityCloak/blob/main/src/main/java/com/pgdinelli/Main.java)

# Autor
Paulo Guilherme Souza Dinelli<br>
Linkedin: [https://www.linkedin.com/in/paulodinelli/](https://www.linkedin.com/in/paulodinelli/)
