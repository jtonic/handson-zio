# README

## How to run the project

- shortest version

```bash
sbt "project web" run
```

- a bit longer

```bash
sbt "project web" "runMain handson.zio.web.Main"
```

- probably the longest

```bash
$ sbt
> projects
> project web
> show discoveredMainClasses
> runMain handson.zio.web.Main
```
