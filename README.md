# Unit Converter

A web-based unit converter built in Java, using only the JDK's built-in HTTP server; no external frameworks or libraries.

Project idea: https://roadmap.sh/projects/unit-converter

Repository: https://github.com/aurealis6/unit-converter

## Features

- Convert between units of **length**, **weight**, and **temperature**
- Live category switching (Length / Temperature / Weight) with no page reload, powered by JavaScript
- Clean, formatted results — capped at 5 decimal places with unnecessary trailing zeros removed
- Responsive layout that adapts to smaller screens
- Custom styling with a segmented pill menu and colored conversion cards

![Unit Converter - Length](screenshots/Desktop_Length.jpg)


## How it works

- **`Server.java`** a minimal Java web server built on `com.sun.net.httpserver.HttpServer`. It serves the HTML form, the stylesheet, and a custom font, and exposes a `/convert` endpoint that reads submitted values from the query string and returns a converted result as plain text.
- **`Converter.java`** contains the conversion logic for each unit category. Length and weight conversions go through a common base unit (meters and kilograms respectively); temperature conversions go through Celsius as an intermediate step.
- **`form.html`** the page itself. A small amount of JavaScript handles switching between unit categories and submitting the form via `fetch()`, so the result updates without a full page reload.
- **`unit-converter-style.css`** styling for the page, including a responsive layout for smaller screens.

## Requirements

- Java (JDK 17 or later recommended)
- No external libraries or dependencies

## Running it

1. Clone the repository:
   ```bash
   git clone https://github.com/aurealis6/unit-converter.git
   cd unit-converter
   ```

2. Compile the source code:
   ```bash
   javac src/*.java -d out
   ```

3. Run the server:
   ```bash
   java -cp out Server
   ```

4. Open your browser to:
   ```
   http://localhost:8080
   ```

## Supported units

**Length:** meter, foot, centimeter, millimeter, kilometer, inch, yard, mile
**Weight:** kilogram, gram, milligram, pound, ounce
**Temperature:** celsius, fahrenheit, kelvin
