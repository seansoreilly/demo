# Create a REST API App

- **Java Version**: 8
- **Spring Boot**: 3
- **Build Tool**: Gradle
- **Testing Framework**: JUnit 4
- **Preferences**: Prefer to use Spring Boot starters

---

## Upgrade Instructions

When asked to "upgrade to Java 17", upgrade the repository to the following:

- **Java Version**: 17
- **Spring Boot**: 3
- **Build Tool**: Gradle
- **Testing Framework**: JUnit 5
- **Preferences**: Prefer to use Spring Boot starters, avoid using Mockito and Hamcrest

---

You can use brave web search using the mcp server if you are unsure or need to clarify
documentation, apis, etc.

you need to run "./gradlew clean build --refresh-dependencies" if changing dependencies

---

## Upgrade Phases

### Phase 1 - Java Version Update

1. Update only Java version to 17 in `build.gradle`.
2. Run tests and application to verify basic functionality.
3. Fix any immediate Java version compatibility issues.

### Phase 2 - Spring Boot Update

1. Update Spring Boot to 3.x and dependency management.
2. Update `javax.*` imports to `jakarta.*`.
3. Run tests and verify application works.

### Phase 3 - Testing Framework

1. Migrate from JUnit 4 to JUnit 5.
2. Update test cases with minimal changes.
3. Verify all tests pass.

### Phase 4 - Java 17 Feature Implementation

1. Convert POJOs to records where appropriate (e.g., PaymentRequest, PaymentResponse)
2. Implement pattern matching for instanceof where applicable
3. Add sealed interfaces/classes where beneficial
4. Utilize text blocks for any multi-line strings
5. Add switch expressions where appropriate

### Phase 5 - Spring Boot 3 Improvements

1. Implement Spring Boot 3 native configuration properties
2. Add Spring Boot actuator endpoints for monitoring
3. Implement improved error handling with ProblemDetail
4. Add OpenAPI 3 documentation
5. Implement versioned APIs using API versioning support

### Phase 6 - Testing Enhancements

1. Implement parameterized tests using JUnit 5
2. Add nested test classes for better organization
3. Utilize test interfaces for shared test behavior
4. Implement parallel test execution
5. Add dynamic tests where appropriate
