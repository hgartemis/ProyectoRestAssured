Feature: Login

  # este es un comentario
  # este es otro comentario
  Background:
    Given yo voy a la pagina todo.ly
    When ingreso mi email : prueba@prueba.com
    And ingreso mi password : 12345

  Scenario: COMO usuario comun
  QUIERO poder autenticarme usando mi email y mi password
  PARA ingresar a la pagina todo.ly

    And hago click en el boton login
    Then yo deberia de ingresar a la aplicacion

  Scenario: COMO usuario comun
  QUIERO poder autenticarme usando mi email y mi password
  PARA ingresar a la pagina todo.ly

    And hago click en el boton login
    Then yo deberia de ingresar a la aplicacion
