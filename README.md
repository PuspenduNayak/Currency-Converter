# Java Currency Converter 💱

A fast, reliable, and user-friendly command-line currency converter application built in Java. This tool leverages the ExchangeRate-API to provide real-time exchange rates for accurate conversions between 160+ global currencies.

![Java](https://img.shields.io/badge/Java-11+-orange?style=flat&logo=java)
![Maven](https://img.shields.io/badge/Maven-3.6+-blue?style=flat&logo=apache-maven)
![License](https://img.shields.io/badge/License-MIT-green?style=flat)
![API](https://img.shields.io/badge/API-ExchangeRate--API-yellow?style=flat)

## 🌟 Features

- **⚡ Real-Time Exchange Rates** - Fetches live currency data from ExchangeRate-API
- **🌍 Universal Currency Support** - Convert between 160+ currencies (USD, EUR, INR, JPY, GBP, etc.)
- **💻 Interactive CLI** - Clean, intuitive command-line interface with helpful prompts
- **🛡️ Robust Error Handling** - Comprehensive validation for inputs, network issues, and API errors
- **📊 Precise Calculations** - Accurate conversions with proper decimal handling
- **🔧 Easy Setup** - Maven-based dependency management for hassle-free installation

## 🚀 Quick Start

### Prerequisites

Ensure you have the following installed on your system:

| Requirement | Version | Download Link |
|-------------|---------|---------------|
| **Java JDK** | 11 or higher | [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/) |
| **Apache Maven** | 3.6+ | [Maven Downloads](https://maven.apache.org/download.cgi) |
| **IDE (Optional)** | Latest | [IntelliJ IDEA](https://www.jetbrains.com/idea/) / [Eclipse](https://www.eclipse.org/) / [VS Code](https://code.visualstudio.com/) |

### API Key Setup

This application requires a **free API key** from ExchangeRate-API:

1. **📝 Sign Up**: Visit [www.exchangerate-api.com](https://www.exchangerate-api.com)
2. **🔑 Get Free Key**: Click **"Get Free Key"** and create your account
3. **📧 Verify Email**: Check your inbox and verify your email address
4. **📋 Copy API Key**: Login to your dashboard and copy the provided API key

> **💡 Tip**: The free tier provides 1,500 requests per month, which is perfect for personal use!

## 💻 Installation

### 1. Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/java-currency-converter.git
cd java-currency-converter
```

*Replace `YOUR_USERNAME` with your actual GitHub username*

### 2. Verify Maven Dependencies

The project uses the following dependencies (automatically managed by Maven):

```xml
<dependencies>
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.10.1</version>
    </dependency>
    <dependency>
        <groupId>org.apache.httpcomponents</groupId>
        <artifactId>httpclient</artifactId>
        <version>4.5.14</version>
    </dependency>
</dependencies>
```

### 3. Build the Project

```bash
mvn clean compile
```

## 🏃‍♂️ Running the Application

### Option 1: Using Maven (Recommended)

```bash
# Build and run in one command
mvn clean compile exec:java -Dexec.mainClass="CurrencyConverter"
```

### Option 2: Using IDE

1. **Import Project**: Open the project folder in your IDE
2. **Maven Sync**: Let the IDE import Maven dependencies
3. **Run Main**: Navigate to `src/main/java/CurrencyConverter.java` and run the `main` method
4. **Follow Prompts**: Interact with the application in the IDE console

### Option 3: Manual Compilation

```bash
# Compile with dependencies
mvn clean package

# Run the JAR file
java -cp target/currency-converter-1.0.jar CurrencyConverter
```

## 📱 Usage

### Sample Session

```
#########################################
###   Real-Time Currency Converter    ###
#########################################

🔑 Enter your API Key from ExchangeRate-API: your_api_key_here
💰 Enter the amount to convert: 250.50
📤 Enter the source currency code (e.g., USD, EUR): USD
📥 Enter the target currency code (e.g., INR, JPY): EUR

---------- Conversion Result ----------
✅ 250.50 USD = 227.45 EUR
📊 Exchange Rate: 1 USD = 0.9084 EUR
📅 Last Updated: 2025-07-19 10:30:00 UTC
---------------------------------------

🙏 Thank you for using the Currency Converter!
```

### Supported Currency Codes

The application supports 160+ currencies. Here are some popular ones:

| Code | Currency | Code | Currency |
|------|----------|------|----------|
| **USD** | US Dollar | **EUR** | Euro |
| **GBP** | British Pound | **JPY** | Japanese Yen |
| **INR** | Indian Rupee | **CAD** | Canadian Dollar |
| **AUD** | Australian Dollar | **CHF** | Swiss Franc |
| **CNY** | Chinese Yuan | **KRW** | South Korean Won |

> **📋 Full List**: Visit [ExchangeRate-API Currency List](https://www.exchangerate-api.com/docs/supported-currencies) for all supported currencies.

## 🏗️ Project Structure

```
java-currency-converter/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── CurrencyConverter.java    # Main application class
│   │       ├── ApiClient.java            # HTTP client for API calls
│   │       ├── ExchangeRateResponse.java # Response model
│   │       └── ValidationUtils.java      # Input validation utilities
│   └── test/
│       └── java/
│           └── CurrencyConverterTest.java # Unit tests
├── pom.xml                              # Maven configuration
├── README.md                            # This file
└── LICENSE                              # MIT License
```

## 🛠️ Built With

| Technology | Purpose | Version |
|------------|---------|---------|
| **[Java](https://www.oracle.com/java/)** | Core Programming Language | 11+ |
| **[Maven](https://maven.apache.org/)** | Build Tool & Dependency Management | 3.6+ |
| **[Gson](https://github.com/google/gson)** | JSON Serialization/Deserialization | 2.10.1 |
| **[ExchangeRate-API](https://www.exchangerate-api.com/)** | Real-Time Currency Exchange Data | v6 |
| **[Apache HttpClient](https://hc.apache.org/)** | HTTP Requests | 4.5.14 |

## 🔧 Configuration

### Environment Variables (Optional)

You can set your API key as an environment variable to avoid entering it each time:

```bash
# Windows
set EXCHANGE_RATE_API_KEY=your_api_key_here

# macOS/Linux
export EXCHANGE_RATE_API_KEY=your_api_key_here
```

### Application Properties

Create a `config.properties` file in the root directory:

```properties
# API Configuration
api.key=your_api_key_here
api.base.url=https://v6.exchangerate-api.com/v6/
api.timeout=5000

# Application Settings
app.precision=2
app.retry.attempts=3
```

## 🧪 Testing

Run the included unit tests to ensure everything works correctly:

```bash
# Run all tests
mvn test

# Run tests with coverage
mvn test jacoco:report
```

## 🐛 Troubleshooting

### Common Issues

**❌ "Invalid API Key" Error**
- Verify your API key is correct and active
- Ensure you've verified your email with ExchangeRate-API
- Check for extra spaces when copying the key

**❌ "Network Connection Error"**
- Check your internet connection
- Verify firewall settings allow HTTP requests
- Try using a different network

**❌ "Currency Not Supported" Error**
- Use standard 3-letter currency codes (ISO 4217)
- Check the [supported currencies list](https://www.exchangerate-api.com/docs/supported-currencies)
- Ensure proper capitalization (e.g., "USD" not "usd")

**❌ Maven Build Failures**
- Ensure Java 11+ is installed and configured
- Check Maven is properly installed with `mvn --version`
- Clear Maven cache: `mvn dependency:purge-local-repository`

### Debug Mode

Run with debug output for troubleshooting:

```bash
mvn exec:java -Dexec.mainClass="CurrencyConverter" -Dlog.level=DEBUG
```

## 🚧 Roadmap

### Planned Features
- [ ] **💾 Offline Mode** - Cache exchange rates for offline use
- [ ] **📊 Historical Rates** - View currency trends and historical data
- [ ] **💱 Batch Conversion** - Convert multiple amounts at once
- [ ] **🖥️ GUI Version** - JavaFX-based graphical interface
- [ ] **📱 Rate Alerts** - Notify when rates reach target values
- [ ] **📈 Currency Charts** - Visual representation of exchange rate trends
- [ ] **🌐 Multiple API Support** - Fallback to alternative rate providers

### Technical Improvements
- [ ] **⚡ Caching System** - Reduce API calls with intelligent caching
- [ ] **🔄 Async Operations** - Non-blocking API requests
- [ ] **📝 Enhanced Logging** - Comprehensive logging with different levels
- [ ] **⚙️ Configuration File** - External configuration management
- [ ] **🧪 More Tests** - Comprehensive test coverage

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. **🍴 Fork** the repository
2. **🌿 Create** a feature branch: `git checkout -b feature/amazing-feature`
3. **✨ Make** your changes and add tests
4. **✅ Test** your changes: `mvn test`
5. **📝 Commit** your changes: `git commit -m 'Add amazing feature'`
6. **🚀 Push** to the branch: `git push origin feature/amazing-feature`
7. **📬 Submit** a Pull Request

### Development Guidelines
- Follow Java coding conventions
- Add unit tests for new features
- Update documentation as needed
- Ensure backward compatibility

## 📄 License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- **[ExchangeRate-API](https://www.exchangerate-api.com/)** for providing reliable currency data
- **[Google Gson](https://github.com/google/gson)** for excellent JSON handling
- **Apache Software Foundation** for HTTP client libraries
- **Oracle/OpenJDK Community** for the Java platform
- **Open Source Community** for inspiration and feedback

## 👤 Author

**Your Name** - [Puspendu Nayak]((https://github.com/PuspenduNayak)

## 📞 Suppor

If you encounter any issues or have questions:

- **📧 Email**: your.email@example.com
- **🐛 Issues**: [GitHub Issues](https://github.com/YOUR_USERNAME/java-currency-converter/issues)
- **💬 Discussions**: [GitHub Discussions](https://github.com/YOUR_USERNAME/java-currency-converter/discussions)

---

**⭐ Star this repository if you find it helpful!**

*Made with ❤️ for the developer community*
