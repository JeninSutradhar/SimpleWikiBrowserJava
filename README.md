# JavaFX Wiki Browser

A simple JavaFX-based Wikipedia browser application. This application allows users to search for Wikipedia articles directly from a simple user interface.

## Prerequisites

Before you can run the application, you need to ensure you have the following installed:

*   **Java Development Kit (JDK):** You need Java 8 or higher. You can download from [Oracle](https://www.oracle.com/java/technologies/downloads/). You may also be able to use an OpenJDK distribution (e.g. [Adoptium](https://adoptium.net/)).
*   **Apache Maven:** This project uses Maven to manage dependencies and build process. Download and install it from [Apache Maven](https://maven.apache.org/).

## How to Run

Here are the steps to get the application up and running:

1.  **Clone the repository:**

    ```bash
    git clone [<your-github-repo-url>](https://github.com/JeninSutradhar/SimpleWikiBrowserJava)
    cd SimpleWikiBrowser
    ```
    Replace `[<your-github-repo-url>](https://github.com/JeninSutradhar/SimpleWikiBrowserJava)` with the actual URL of your GitHub repository.

2.  **Build the project using Maven:**

    ```bash
    mvn clean install
    ```

    This command will download any required dependencies (like JavaFX and jsoup), compile the source code and package it into a form that can be executed.

3.  **Run the application:**

    ```bash
    mvn javafx:run
    ```

    This will start the JavaFX application.

## Usage

1.  Once the application starts, a Wikipedia start page will be displayed by default.
2.  Enter the title of a Wikipedia article into the search bar.
3.  Click on the "Search" button.
4.  The browser will load the specified page. If the page doesn't exist, the default wikipedia page will be loaded.
5.  You can navigate through the webpage as usual.

## Troubleshooting

*   **Dependency Issues:** If you encounter errors during the `mvn clean install` step, make sure Maven is correctly configured and that you have a stable internet connection to download the project's dependencies.
*   **Java Version:** Ensure that you are using a version of Java 8 or later as specified in the `pom.xml` file.
*   **JavaFX:** JavaFX is needed for this application. If you face a javaFX error message, you should review if your Maven install is using correctly JavaFX.

## Contributing

Contributions are welcome! Feel free to submit issues and pull requests.

## License

This project is licensed under the [MIT License](LICENSE.md). (If you want to include a license)
