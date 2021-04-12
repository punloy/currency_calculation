# currency_calculation

This is a backend server for currency_calculation

## Develop environment
- Java version:16
- VS Code
- Windows 19

## Database
```bash=
$ docker run --name currencycalculation -e POSTGRES_PASSWORD=pwd -p 5432:5432 -d postgres
```
create table
```sql=
CREATE TABLE "calculate_record" (
	"id" INTEGER NOT NULL DEFAULT 'nextval(''record_id_seq''::regclass)',
	"currency" VARCHAR(10) NOT NULL,
	"rate" NUMERIC(16,2) NOT NULL,
	"price" NUMERIC(16,2) NULL DEFAULT NULL,
	"discount" NUMERIC(16,2) NULL DEFAULT NULL,
	"result" NUMERIC(16,2) NULL DEFAULT NULL,
	"record_time" TIMESTAMP NOT NULL DEFAULT 'now()',
	PRIMARY KEY ("id")
)
```

## Run 
```bash= 
$ mvnw spring-boot:run
```

### Show result
