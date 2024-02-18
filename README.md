Si vous n’avez pas JDK installé sur votre machine vous pouvez l’installer en cliquant sur le lien ci-dessous.
https://www.oracle.com/fr/java/technologies/downloads/

Sur Windows, vous devez avoir le JDK sur vos variables d’environnement sur l’ordinateur. La variable “Path” doit contenir l’adresse du fichier “bin” sur l’endroit d’installation du JDK. Normalement, nous pouvons le retrouver en suivant le chemin indiqué ci-dessous :

C:\Program Files\Java\jdk-21\bin

Si vous n’avez pas cela dans votre machine, vous pouvez créer une nouvelle variable d’environnement appelé “Path” avec l’emplacement du JDK mentionné. 
Pour lancer le fichier Jar du projet il faut vous rendre sur le terminal dans le dossier contenant le jar (et le code du projet) et écrire la commande suivante :

```bash
java -jar --enable-preview dd.jar
```
