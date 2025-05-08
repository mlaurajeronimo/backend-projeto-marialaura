# MinhaBagagem

Projeto desenvolvido para a disciplina de Backend com o objetivo de sugerir o que levar na mala de acordo com o clima atual de um destino escolhido pelo usuário.

### Aluna: Maria Laura Jeronimo


##  Objetivo

A proposta do projeto é oferecer um sistema onde o usuário pode:
- Adicionar o nome de uma cidade que deseja visitar.

- Ver detalhes como nome da cidade, descrição e o clima atual da cidade (através de uma API externa).

- Editar ou deletar lugares cadastrados.

- Receber sugestões do que levar na mala com base na temperatura do local.

## Estrutura do Projeto

- O projeto segue a arquitetura em camadas (MVC), separando claramente responsabilidades entre controller, service e model.

controller: Define as rotas da aplicação.

service: Contém a lógica de negócio.

model: Contém as classes que representam os dados da aplicação.

#### - Projeto rodando na porta 8000. (http://localhost:8000)


### - API externa:

-Foi utilizada a API do OpenWeatherMap para obter as informações climáticas em tempo real. O consumo é feito através da classe 'WeatherService'.
(https://openweathermap.org/current).

##  Tecnologias utilizadas:

-Java 17+

-Spring Boot

-Spring Web

-OpenWeatherMap API (clima)

-JSON

-IntelliJ IDEA

-Postman

##  Endpoints disponíveis:

###  Lugares

- `POST /lugares`: adiciona um novo lugar 

- Exemplo de requisição: 
```
{
  "cidade": "Paris"
}
```

-Exemplo de resposta:
```
Lugar adicionado com sucesso!
```


- `GET /lugares`: lista todos os lugares

- `GET /lugares/buscar?nome=Paris`: busca lugares pelo nome
- `PUT /lugares/{nome}`: edita um lugar existente
- `DELETE /lugares/{nome}`: deleta um lugar


###  Clima

- `GET /lugares/clima?cidade=Paris`: busca o clima atual da cidade informada
- `GET /lugares/clima/sugestao?cidade=Paris` : Retorna o clima e sugestões de bagagem baseadas na temperatura.
 

- Exemplo de resposta:
`GET /lugares/clima/sugestao?cidade=Paris`

```json
{
  "cidade": "Paris",
  "temperatura": 15.4,
  "descricao": "nublado",
  "sugestoes": [
    "Levar uma jaqueta leve",
    "Talvez um guarda-chuva"
  ]
}
```
`POST /lugares/clima`: permite enviar a cidade via corpo da requisição (JSON)
- Exemplo de requisição:

```
POST /lugares/clima
Content-Type: application/json

{
  "cidade": "Paris"
}
```
- Exemplo de resposta: 
```
{
  "cidade": "Paris",
  "temperatura": 14.17,
  "descricao": "céu limpo",
  "sugestoes": [
    "Casaco",
    "Cachecol",
    "Roupas térmicas"
  ]
}
```

## Rota /sobre 

- O projeto contem uma rota /sobre que responde de acordo com o modelo abaixo: 
 
Exemplo de requisição:
```http://localhost:8000/lugares/sobre```

Exemplo de resposta:
```
{
    "nome_projeto": "minhabagagem",
    "integrante": [
        "Maria Laura Jeronimo"
    ]
}
```

