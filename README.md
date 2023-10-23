# Resourcium Optima

Resourcium Optima is a startup project aimed at revolutionizing resource allocation and optimization for businesses, enhancing efficiency and sustainability in their operations.

## Installation

To install and run Resourcium Optima, ensure you have the following prerequisites installed on your system:

- Java JDK 20
- Apache Maven
- MySQL Server
- Tomcat

Follow these steps to set up and run the Resourcium Optima project:

1. **Clone the Repository:**

    ```bash
    git clone https://github.com/jesakim/resourcium-jee
    ```

2. **Build the Project:**

   Navigate to the project root directory and build the project using Maven:

    ```bash
    cd resourcium-jee
    mvn clean install
    ```

3. **Database Configuration:**

Edit Database Connection Properties in the 'persistence.xml':

```bash
<persistence-unit name="your-persistence-unit-name">
    <properties>
        <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/yourdb"/>
        <property name="javax.persistence.jdbc.user" value="yourusername"/>
        <property name="javax.persistence.jdbc.password" value="yourpassword"/>
    </properties>
</persistence-unit>
```


4. **Deploy the Application:**

   Deploy the generated WAR file (`resourcium-jee.war`) to your servlet container (e.g., Tomcat).

5. **Access the Application:**

   Open a web browser and access the application using the appropriate URL based on your servlet container configuration.

## Project Structure

The project follows the Maven standard directory structure. Here's a brief overview of key directories:

- `src/main/java`: Java source code
- `src/main/resources`: Resource files and configuration
- `src/test`: Unit and integration tests
- `pom.xml`: Maven project configuration file

## Technologies Used

- Java
- Maven
- MySQL
- Jakarta Servlet API
- Hibernate
- JUnit

For more information and detailed project documentation, please refer to the project repository.

For any inquiries or issues, feel free to [contact us](https://github.com/jesakim/resourcium-jee).