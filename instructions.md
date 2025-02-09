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

### Phase 4 - Enhancements (Optional)

1. Implement Java 17 features (records, pattern matching, etc.).
2. Add Spring Boot improvements.
3. Enhance testing with new capabilities.
