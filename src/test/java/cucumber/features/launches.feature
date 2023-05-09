Feature: Dashboards feature tests

  Background:
    Given open ReportPortal
    And click on launches tab

  Scenario: User can add and delete filters on launches tab
    And filter has 1 items
    When click on add new filter
    Then filter has 2 items
    And click on delete last added filter
    And filter has 1 items

  Scenario: User can see that first launch has no failures
    When click on sorting "fl"
    Then first launch sorted by "failed"

  Scenario Outline: User can sorted launches
    When click on sorting "<button>"
    Then first launch sorted by "<filter>"
    Examples:
      | button    | filter    |
      | fl        | failed    |
      | skp       | skipped   |
      | to invest | to invest |