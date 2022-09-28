# Spring-Demo

## APIs i microserveis

- L'arquitectura de microserveis és la més emprada avui en dia, i es basa en aplicacions petites, auto-contingudes (independents) i escalables.
- Un microservei implementa una funcionalitat concreta. En el nostre cas, un sistema de gestió d'usuaris.
- Ens comuniquem amb ell mitjançant una API (Application Programming Interface), que fem servir per distribuir el servei i permet accedir a les seves funcionalitats.
- Una API exposa endpoints que permeten comunicarse amb els sistemes a què està connectada. Una de les maneres és fent servir requests HTTP, emprant els verbs HTTP (GET, POST, PUT, DELETE).

## Introducció a Spring i Spring Boot

- Spring és el framework basat en Java més emprat amb diferència. Permet deesnvolupar aplicacions Java així com aplicacions web i es basa en l'ús de la programació amb POJOs com a base.
La seva estructura modular permet emprar els packages i classes que es necessiten per una aplicació concreta, testejar i emprar injecció de dependències de manera fàcil.
- Spring Boot és un framework que s'usa per crear aplicacions i microserveis basats en Spring de manera senzilla. Permet configurar de manera automàtica molts aspectes de Spring i ens estalvia molta feina.

## Demostració d'una API amb Spring Boot (sistema de gestió d'usuaris)

- API senzilla que exposa endpoints per fer servir un servei de gestió d'usuaris (amb creació, actualització, eliminació i consulta de dades), és a dir, fer operacions CRUD.
- Temes a tenir en compte:
  - Pom (gestió de dependències) - Maven
  - Propietats de l'aplicació
  - Estructura dels packages i funció de cadascun
  - Ús de Postman
  - Testing
  - Bones pràctiques:
    - Injecció de dependències. @Autowired no és sempre necessari, és preferible usar injecció al constructor.
    - Ús d'anotacions (@RestController, @Service, etc.)
    - Ús de DTOs - ModelMapper
    - Documentació amb Swagger - Configuració
    - Ús de noms plurals per identificar el recurs (en aquest cas, users)
    - (Opcional) Ús de Lombok
    - Validació de dades
    - Gestió d'errors i excepcions
    - Ús correcte de codis HTTP de resposta
