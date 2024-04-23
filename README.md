# Mini-Projet JAVA
## Cryptographie

Auteur : Mazzone Rémi (rems-38) \
Version actuelle : 1.0

### Usage

Pour lancer le programme, il suffit de lancer la commande suivante :

```bash
java -jar Main.jar -e|-d alg text [args ...]
```

Si vous avez modifié le code ou que vous souhaitez recompiler le programme, vous pouvez utiliser la commande suivante :

```bash
./make.sh -e|-d alg text [args ...]
```

### Compilation

Pour compiler le programme, il suffit d'utiliser la commande suivante :

```bash
./make.sh
```

Son utilisation sans argument permet de compiler le programme sans lancer son exécution.

### Arguments

- `-e` : Permet de chiffrer le texte
- `-d` : Permet de déchiffrer le texte

- `alg` : Algorithme de chiffrement à utiliser
  - `rot13` : Cas particulier d'un code de césar
  - `caesar` : Codes de César
  - `sub` : Codes de substitution
  - `otp` : Chiffrement de Vernam

- `text` : Texte à chiffrer ou déchiffrer
- `args ...` : Arguments supplémentaires pour les algorithmes
    - `rot13` : Aucun argument
    - `caesar` : n° de décalage (nombre entier entre 1 et 26)
    - `sub` : table de substitution (chaine de caractères de 26 ou 52 caractères uniques)
    - `otp` : clé de chiffrement (chaine de caractères de longueur supéreieure ou égale au texte)

### Problèmes connus

- Lors du passage de l'argument `text`, si ce dernier contient des espaces, il est nécessaire de l'entourer de guillemets (`"`). Cependant, ceci ne fonctionne que lors de l'appel du programme avec la commande `java` (cela ne fonctionne pas avec le script `make.sh` pour des raisons encore inconnues de passage de paramètres via _bash_).