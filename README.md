# Swiftnotes

- Запуск всех тестов: adb shell am instrument -w -m    -e package com.moonpi.swiftnotes.tests -e debug false com.moonpi.swiftnotes.test/io.qameta.allure.android.runners.AllureAndroidJUnitRunner
- Отчеты хранятся на sd карте эмулятора/устройства, на котором запускались тесты.
В учебном демо-приложении использовались:
  - JUnit для запуска тестов;
  - Allure Kotlin для генерации отчетов;
  - Espresso для взаимодействия с UI-элементами.
Тесты написаны с использованием паттерна PageObject.
  
### Build

Steps on how to build Swiftnotes:
- Make sure you have the latest version of Android Studio with Gradle v2.3.1 and the required Android SDK Tools installed (25.0.3 Build tools)

### License

Copyright &copy; 2018 Adrian Chifor

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
