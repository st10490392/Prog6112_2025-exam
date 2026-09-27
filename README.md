# Prog6112_2025-exam

PROG6112 Supplementary Exam — Ripfumelo Vunene Ngobeni (ST10490392).

The repository contains two Java projects:

| Project | Build tool | Description |
|---|---|---|
| [`HospitalOperationsApp`](HospitalOperationsApp) | Maven | Console menu app that reports total, average, max and min hospital operations over two years of quarterly data. Includes JUnit 5 tests. |
| [`HospitalOperationsGUI`](HospitalOperationsGUI) | Ant (NetBeans) | Swing GUI that shows yearly/overall operation totals and saves the report to `data.txt`. |

Requires **JDK 17 or newer**.

## Download

Every push builds both jars in GitHub Actions (see the *Actions* tab → latest run → *Artifacts*).
Pushing a tag such as `v1.0.0` also publishes them on the *Releases* page:

```bash
git tag v1.0.0
git push origin v1.0.0
```

## Build and run locally

### Console app

```bash
cd HospitalOperationsApp
mvn package                                   # compiles and runs the unit tests
java -jar target/HospitalOperationsApp.jar
```

### GUI app

```bash
cd HospitalOperationsGUI
ant jar
java -jar dist/HospitalOperations.jar
```

Both projects also open directly in NetBeans.
