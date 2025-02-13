## Related Issue
<!--- If this is a feature or a bug fix, make sure to link the related issue here -->
closes #

## Description
<!--- Describe your changes -->

## Test artifact

**Test models updated?**

In case you created a new APIObject or extracted one,
make sure to update the test fakes in [`test/src/commonMain/models`](../test/src/commonMain/kotlin/com/ioki/passenger/api/test/models) as well.

Changes to existing models will probably fail on testing and are noticed by the CI.

**Test services updated?**

In case you created a new service or extracted one,
make sure to update the test fakes in [`test/src/commonMain/services`](../test/src/commonMain/kotlin/com/ioki/passenger/api/test) as well.

Changes to existing services will probably fail on testing and are noticed by the CI.
