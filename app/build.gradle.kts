plugins {
    application
    id("org.openjfx.javafxplugin") version "0.1.0"
    id("com.gradleup.shadow") version "8.3.5"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.palexdev:materialfx:11.17.0")
}

javafx {
    modules("javafx.controls", "javafx.fxml")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(23)
    }
}

application {
    mainClass = "tictactoe.TicTacToe"
}