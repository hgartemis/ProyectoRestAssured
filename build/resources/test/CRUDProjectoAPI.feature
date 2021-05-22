Feature: Projecto

  @API
  Scenario: como usuario quiero crear actualizar y borrar un projecto para controlar las transacciones

    Given que tengo acceso al API de todo.ly
    When yo ejecuto un POST request a "http://todo.ly/api/projects.json" con el body
    """
    {
      "Content":"CUCUMBER",
      "Icon":"2"
    }
    """
    Then yo espero que el codigo de respuesta sea 200
    And espero que el Content sea "CUCUMBER"
    And yo recupero el Id del projecto en ID_PROJECT
    When yo ejecuto un PUT request a "http://todo.ly/api/projects/ID_PROJECT.json" con el body
    """
    {
      "Content":"CUCUMBERUPDATE",
      "Icon":"2"
    }
    """
    Then yo espero que el codigo de respuesta sea 200
    And espero que el Content sea "CUCUMBERUPDATE"
    When yo ejecuto un DELETE request a "http://todo.ly/api/projects/ID_PROJECT.json"
    Then yo espero que el codigo de respuesta sea 200
    And espero que el Content sea "CUCUMBERUPDATE"