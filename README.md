# Mob Highlight — мод для Fabric 1.21.11

Подсветка мобов при наведении прицела + звук при ударе по мобу. Игроков мод не затрагивает.

## Важно: файла gradle-wrapper.jar в архиве нет

У меня в песочнице нет доступа в интернет, поэтому я не могу скачать `gradle-wrapper.jar`
(бинарный файл) и сам собрать `.jar` мода. Тебе нужно сделать один из двух вариантов —
оба займут пару минут.

### Вариант A (проще всего) — открыть в IntelliJ IDEA

1. Скачай и установи [IntelliJ IDEA Community](https://www.jetbrains.com/idea/download/) (бесплатно).
2. File → Open → выбери папку `mobhighlight` (эту, распакованную).
3. IntelliJ увидит `build.gradle` и предложит импортировать проект как Gradle-проект — согласись.
4. Он сам скачает Gradle wrapper, Minecraft, Fabric API и т.д. (нужен интернет на этом шаге).
5. Справа откроется панель Gradle → `Tasks` → `build` → двойной клик по `build`.
6. Готовый `.jar` появится в `build/libs/mobhighlight-1.0.0.jar`.

### Вариант B — если у тебя уже установлен Gradle

1. Открой терминал в папке `mobhighlight`.
2. Выполни:
   ```
   gradle wrapper --gradle-version 8.10
   ```
   Это создаст `gradlew`, `gradlew.bat` и `gradle-wrapper.jar`.
3. Дальше собери мод:
   - Windows: `gradlew.bat build`
   - Linux/Mac: `./gradlew build`
4. Готовый `.jar` — в `build/libs/mobhighlight-1.0.0.jar`.

## Установка мода

1. Убедись, что установлен **Fabric Loader** для Minecraft 1.21.11 и **Fabric API** (мод-зависимость, скачивается отдельно с Modrinth/CurseForge).
2. Положи собранный `mobhighlight-1.0.0.jar` в папку `mods` (и клиента, и сервера, если играете вместе).
3. Запусти игру.

## Если сборка выдаёт ошибку версий

Версии в `gradle.properties` (yarn_mappings, loader_version, fabric_version) могут немного
устареть к моменту, когда ты это читаешь. Если Gradle пишет "could not resolve" —
зайди на https://fabricmc.net/develop и подставь актуальные версии для Minecraft 1.21.11.

## Что делает мод

- Наводишь прицел на моба (не на игрока) в радиусе 6 блоков → он подсвечивается контуром.
- Бьёшь моба → проигрывается звук удара.
- На игроков (реальных людей) мод не действует — специально, чтобы не давать нечестного
  преимущества в PvP.
