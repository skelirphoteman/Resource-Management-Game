# Cahier des charges

Au début du jeu, le joueur commence au niveau 1 et avec :

- 50 or

Le but est d'atteindre le niveau maximum (2 dans la première version).

Pour passer un niveau il faut avoir les ressources demander par celui-ci.

Exemple : passage niveau 1 = 20or,  20 de bois et 20 de fers

Il existe 3 types de ressource :

- Or
- Bois
- Fer

Pour récolter ces ressources, il faut acheter des extracteurs de ressources. Plusieurs niveaux sont disponibles à l'achat et/ou en amélioration (niveau n à n+1). Voici les extracteurs :

Extracteur d'or :

| Niveau | Coûts | Gains (par minutes) |
| --- | --- |---------------------|
| 1 | 35 or | 15                  |
| 2 | 100 or; 20 bois; | 60 |

Extracteur de bois :

| Niveau | Coûts          | Gains (par minutes) |
| --- |----------------|---------------------|
| 1 | 70 or          | 10                  |
| 2 | 150 or; 5 fer; | 30                  |


Extracteur de fer :

| Niveau | Coûts                   | Gains (par minutes) |
| --- |-------------------------|---------------------|
| 1 | 100 or; 10 bois         | 2                   |
| 2 | 180 or;30 bois; 5 fers; | 8                   |

Il faut récolter les ressources pour pouvoir les utiliser.

Pour calculer la quantité de ressources ajoutée au stockage du joueur, il faut prendre quand est-ce que la dernière récolte a eu lieu (lastCollect) et le moment de la collecte (currentTime) et faire :
currentTime - lastCollect = temps écoulé

Le temps écoulé est en minute, et l'on multiplie cette valeur par le rendement par minute de l'extracteur k

Version 1 : Jouable avec l'invite de commande

Voici les actions possibles :

- Acheter un extracteur
- Améliorer un extracteur
- Récolter toutes les ressources
- Voir les informations globales (niveau, nombre de ressources, extracteur
- Passer de niveau (et gagner)


# Etude préliminaire

Acteurs :
- Joueur

Messages :
- Acheter, améliorer et récolter un extracteur
- Information des ressources
- Passer de niveau


Regroupement : 

| Emetteur | Récepteur | Message(s)                            |
|--------| --------- |---------------------------------------|
| Joueur | Jeu | Lancer le jeu              |
| Joueur | Jeu | Acheter/Améliorer/Récolter Extracteur |
| Joueur | Jeu | Passer de niveau                      |
| Jeu | Joueur | Informations ressources / joueur      |

![](https://github.com/skelirphoteman/jeu-de-strategie/blob/main/ProjectManagment/UML/DContextary.png)


# Capture des besoins fonctionnels

Diagramme de use case :

![](https://github.com/skelirphoteman/jeu-de-strategie/blob/main/ProjectManagment/UML/DUseCase.png)

Les fiches de scénario se trouvent dans le dossier **Scenarios**  