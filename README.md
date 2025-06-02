<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JavaFX Calculator - README</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            margin: 40px;
            line-height: 1.6;
            background-color: #f9f9f9;
            color: #333;
        }
        h1, h2, h3 {
            color: #1e90ff;
        }
        pre {
            background-color: #eee;
            padding: 15px;
            border-radius: 8px;
            overflow-x: auto;
        }
        code {
            background-color: #f3f3f3;
            padding: 2px 4px;
            border-radius: 4px;
        }
        a {
            color: #1e90ff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        .footer {
            margin-top: 50px;
            font-size: 0.9rem;
            color: #777;
        }
    </style>
</head>
<body>

<h1>📱 JavaFX Calculator</h1>

<p>A simple and clean calculator built with <strong>JavaFX</strong> and <strong>SLF4J</strong> for logging.</p>
<p>This project demonstrates modular Java development, clean separation of concerns, and logging integration.</p>

<hr>

<h2>📦 Project Structure</h2>

<pre>
src/main/java
└── com.examples.javacalculator
    ├── constants/
    │   └── StaticConstants.java         // Static values used across the app
    ├── service/
    │   └── CalculatorService.java       // Calculator logic
    ├── Calculator.java                  // UI creation and event handling
    └── Main.java                        // Application entry point
</pre>

<hr>

<h2>🛠️ Features</h2>
<ul>
    <li>Basic arithmetic operations: <code>+</code>, <code>-</code>, <code>*</code>, <code>/</code></li>
    <li>Error handling for:
        <ul>
            <li>Divide by zero</li>
            <li>Invalid input formats</li>
        </ul>
    </li>
    <li><strong>Backspace (←)</strong> button to delete last character</li>
    <li><strong>Decimal (.)</strong> button for floating point operations</li>
    <li>Clear <code>C</code> button</li>
    <li>Logging via <strong>SLF4J</strong> and <strong>Logback</strong></li>
</ul>

<hr>

<h2>📑 Technologies Used</h2>
<ul>
    <li>Java 21+</li>
    <li>JavaFX</li>
    <li>SLF4J</li>
    <li>Logback</li>
</ul>

<hr>

<h2>🚀 How to Run</h2>

<h3>📦 Prerequisites:</h3>
<ul>
    <li>Java 21 or newer installed</li>
    <li>JavaFX SDK installed and added to your classpath</li>
</ul>

<h3>📥 Clone the repository:</h3>

<pre>
git clone https://github.com/dadaboymasharipov/javafx-calculator.git
cd javafx-calculator
</pre>

<h3>🏃 Run the application:</h3>

<p><strong>Using IntelliJ IDEA / Eclipse:</strong></p>
<ul>
    <li>Open project</li>
    <li>Set up JavaFX SDK in project settings</li>
    <li>Run <code>Main.java</code></li>
</ul>

<hr>

<h2>📃 Logging Configuration</h2>

<p>The project uses <strong>SLF4J</strong> with <strong>Logback</strong> for logging.</p>

<ul>
    <li>Log file is written to <code>logs/application.log</code></li>
    <li>To customize logging behavior, update <code>src/logback.xml</code></li>
</ul>

<h3>Example logback.xml:</h3>

<pre>
&lt;configuration&gt;
    &lt;appender name="FILE" class="ch.qos.logback.core.FileAppender"&gt;
        &lt;file&gt;logs/application.log&lt;/file&gt;
        &lt;append&gt;true&lt;/append&gt;
        &lt;encoder&gt;
            &lt;pattern&gt;%d{yyyy-MM-dd HH:mm:ss} %-5level %logger{36} - %msg%n&lt;/pattern&gt;
        &lt;/encoder&gt;
    &lt;/appender&gt;

    &lt;root level="info"&gt;
        &lt;appender-ref ref="FILE" /&gt;
    &lt;/root&gt;
&lt;/configuration&gt;
</pre>

<hr>

<h2>📈 Future Improvements</h2>
<ul>
    <li>Memory (M+) and history functionality</li>
    <li>Keyboard input support</li>
    <li>Scientific calculator mode (sin, cos, log, etc.)</li>
    <li>Theme/dark mode support</li>
</ul>

<hr>

<h2>📄 License</h2>

<p>This project is open-source and free to use under the <strong>MIT License</strong>.</p>

<hr>
<div class="footer">
    &copy; 2025 Masharipov Dadaboy. All rights reserved.
</div>

</body>
</html>
