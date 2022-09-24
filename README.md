![t-books-como-objeto-inteligente-1](https://user-images.githubusercontent.com/71872999/192019488-634c5c82-e374-4950-8466-03c747b0b28a.jpg)

## Autores
- [Oriol Andreazini Sabaté](https://www.linkedin.com/in/oandreazini/)
- [Bárbara Broto Fernández](https://www.linkedin.com/in/barbara-broto/) 
- [Roger Rubio Rufaste](https://www.linkedin.com/in/rogerrubiorufaste/)

## Descripción
Proyecto final del team 1 en el BootCamp de T-Systems Reus. Nuestra página es una plataforma para el préstamo de libros de manera gratuita. Los usuarios pueden tomar prestados y prestar libros a otros usuarios, poniendo también una valoración junto a un comentario en los mismos.

## Documentación de la API
El back-end está implementado en el Framework de Spring, utilizando Maven project, y nuestra BBDD está desplegada en Heroku. Seguidamente, se muestran los endpoints y el nombre de cada función, de nuestra API.

### Book-controller

```
GET /books --> getAllBooks

POST /books --> saveBook

GET /books/{id} --> getBookById

PUT /books/{id} --> updateBook

DELETE /books/{id} --> deleteBook

GET /books/author/{author} --> findBooksByAuthor

GET /books/editorial/{editorial} --> findBooksByEditorial

GET /books/isbn/{isbn} --> findBooksByIsbn

GET /books/title/{title} --> getBooksByTitle

GET /books/user/{id} --> findBooksByIdUsuario

GET /bookspage --> getAPageBooks
```
### Loan-controller
```
GET /loans --> getAllLoans

POST /loans --> saveLoan

GET /loans/{id} --> getLoanById

PUT /loans/{id} --> updateLoan

DELETE /loans/{id} --> deleteLoan

GET /loans/book/{id} --> findLoansByBook

GET /loans/usuario/{id} --> findLoansByUsuario
```
### user-controller
```
POST /register --> saveUser

GET /users --> getAllUsers

GET /users/{id} --> getUserById

PUT /users/{id} --> updateUser

DELETE /users/{id} --> deleteUser

PUT /users/pass/{id} --> updatePass

GET /users/username/{username} --> getUsuarioByUsername
```

## Diagrama d'entidad-relación

![image](https://user-images.githubusercontent.com/55554433/192104094-1d9a3e4c-1d40-4aaa-8126-2c7a7c919fae.png)

