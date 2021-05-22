Feature: Project

  @JBGroup
  Scenario:  CRUD


    Given I have access to API todo.ly
    When I send a request POST to "CREATE_PROJECT" with body
    """
    {
      "Content":"CUCUMBER",
      "Icon":"2"
    }
    """
    Then I expected the response code is 200
    And I expected the response body
    """
    {
      "Id": "IGNORE",
      "Content": "CUCUMBER",
      "ItemsCount": 0,
      "Icon": 2,
      "ItemType": 2,
      "ParentId": null,
      "Collapsed": false,
      "ItemOrder": "IGNORE",
      "Children": [

      ],
      "IsProjectShared": false,
      "ProjectShareOwnerName": null,
      "ProjectShareOwnerEmail": null,
      "IsShareApproved": false,
      "IsOwnProject": true,
      "LastSyncedDateTime": "IGNORE",
      "LastUpdatedDate": "IGNORE",
      "Deleted": false,
      "SyncClientCreationId": null
   }
    """
    And I save the property Id in ID_PROJECT
    When I send a request PUT to "UPDATE_PROJECT" with ID : ID_PROJECT with body
    """
    {
      "Content":"CUCUMBER UPDATE",
      "Icon":"3"
    }
    """
    Then I expected the response code is 200
    And I expected the response body
    """
    {
      "Id": "IGNORE",
      "Content": "CUCUMBER UPDATE",
      "ItemsCount": 0,
      "Icon": 3,
      "ItemType": 2,
      "ParentId": null,
      "Collapsed": false,
      "ItemOrder": "IGNORE",
      "Children": [

      ],
      "IsProjectShared": false,
      "ProjectShareOwnerName": null,
      "ProjectShareOwnerEmail": null,
      "IsShareApproved": false,
      "IsOwnProject": true,
      "LastSyncedDateTime": "IGNORE",
      "LastUpdatedDate": "IGNORE",
      "Deleted": false,
      "SyncClientCreationId": null
   }
    """
    When I send a request DELETE to "DELETE_PROJECT" with ID : ID_PROJECT with body
    """
    """
    Then I expected the response code is 200
    And I expected the response body
    """
    {
      "Id": "IGNORE",
      "Content": "CUCUMBER UPDATE",
      "ItemsCount": 0,
      "Icon": 3,
      "ItemType": 2,
      "ParentId": null,
      "Collapsed": false,
      "ItemOrder": "IGNORE",
      "Children": [

      ],
      "IsProjectShared": false,
      "ProjectShareOwnerName": null,
      "ProjectShareOwnerEmail": null,
      "IsShareApproved": false,
      "IsOwnProject": true,
      "LastSyncedDateTime": "IGNORE",
      "LastUpdatedDate": "IGNORE",
      "Deleted": true,
      "SyncClientCreationId": null
    }
    """
