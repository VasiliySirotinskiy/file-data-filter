# File Data Filter

## Описание проекта
**File Data Filter** – это утилита для фильтрации содержимого текстовых файлов. Программа принимает на вход один или несколько файлов, содержащих вперемешку:
- **Целые числа** → записываются в файл *integers.txt*
- **Вещественные числа** → записываются в файл *floats.txt*
- **Строки** → записываются в файл *strings.txt*

Если данных определённого типа нет, соответствующий файл не создаётся.

## Функционал
- **Настраиваемые выходные файлы**
    - Опция `-p` позволяет задать префикс для выходных файлов.
    - Опция `-o` позволяет указать путь для сохранения выходных файлов.
    - Например: `-p sample_ -o src` создаст файлы `src/sample-integers.txt`, `src/sample-floats.txt`, `src/sample-strings.txt`.

- **Режим статистики**
    - `-s` – краткая статистика (количество элементов).
    - `-f` – полная статистика (для чисел: min, max, сумма, среднее; для строк: длина самой короткой и самой длинной строки).

- **Режим добавления**
    - Опция `-a` позволяет добавлять данные в существующие файлы (по умолчанию файлы перезаписываются).

- **Обработка ошибок**
    - Все ошибки обрабатываются корректно: программа выводит сообщения о проблемах и продолжает выполнение, если это возможно.

## Запуск проекта

### 1. Открытие проекта
Откройте проект в **IntelliJ IDEA**.

### 2. Настройка конфигурации запуска
1. Перейдите в **Run > Edit Configurations...**
2. Создайте новую конфигурацию типа **Application**
3. В поле **Main class** укажите главный класс с методом `main()`
4. В поле **Program arguments** укажите параметры запуска. Пример:

   ```
   -s -p sample_ -o src src/in1.txt src/in2.txt
   ```
   Где:
    - `-s` – включает краткую статистику
    - `-p sample_` – добавляет префикс *sample_* к именам выходных файлов
    - `-o src` – сохраняет файлы в папке `src`
    - `src/in1.txt` и `src/in2.txt` – входные файлы

### 3. Запуск
После настройки конфигурации нажмите **Run** в IntelliJ IDEA.

## Пример работы
При запуске утилиты с аргументами:

```
-s -p sample_ -o src src/in1.txt src/in2.txt
```

Будут созданы файлы:
- `src/sample-integers.txt` (содержит целые числа)
- `src/sample-floats.txt` (содержит вещественные числа)
- `src/sample-strings.txt` (содержит строки)

В консоли выведется статистика по обработанным данным.

## Системные требования
- **Java:** 17.0.9 (LTS)
- **Среда разработки:** IntelliJ IDEA
- **Система сборки:** встроенная система сборки IntelliJ IDEA

---