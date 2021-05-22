Feature: Login

  Scenario Outline: COMO usuario comun
  QUIERO poder autenticarme usando mi email y mi password
  PARA ingresar a la pagina todo.ly

    Given yo voy a la pagina todo.ly
    When ingreso mi email : <email>
    And ingreso mi password : <password>
    And hago click en el boton login
    Then yo deberia de ingresar a la aplicacion
    Examples:
      | email             | password |
      | prueba@prueba.com | 12345    |
      | jb1@jb.com        | 234      |
      | jb2@jb.com        | 454      |
      | jb3@jb.com        | 254      |
