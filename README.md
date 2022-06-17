# Clinic_Manage
- Đây là source code đồ án môn học Ngôn ngữ lập trình Java - SE330.M21.PMCL.
- Sử dụng PostgreSQL để lưu trữ cơ sở dữ liệu. 
# Hướng dẫn cài đặt CSDL
- Tải PostgresSQL tại https://www.postgresql.org/download/ (nếu chưa cài đặt).
- Tạo password truy cập csdl là 123456.
- Chọn Tools -> Query Tool
- Excute những query sau:
```sql
CREATE DATABASE clinic_manage
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.932'
    LC_CTYPE = 'English_United States.932'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
```
```sql
CREATE TABLE IF NOT EXISTS public.account
(
    id integer NOT NULL,
    username text COLLATE pg_catalog."default" NOT NULL,
    password text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT account_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.account
    OWNER to postgres;
```
```sql
CREATE TABLE IF NOT EXISTS public.appointment
(
    appointment_datetime timestamp without time zone NOT NULL,
    patient_id integer NOT NULL,
    doctor_id integer NOT NULL,
    note text COLLATE pg_catalog."default"
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.appointment
    OWNER to postgres;
```
```sql
CREATE TABLE IF NOT EXISTS public.employee
(
    id integer NOT NULL,
    type_of_job text COLLATE pg_catalog."default" NOT NULL,
    full_name text COLLATE pg_catalog."default" NOT NULL,
    email text COLLATE pg_catalog."default",
    phone_number text COLLATE pg_catalog."default",
    salary numeric,
    account_id integer NOT NULL,
    address text COLLATE pg_catalog."default",
    CONSTRAINT employee_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.employee
    OWNER to postgres;
```
```sql
CREATE TABLE IF NOT EXISTS public.import
(
    id integer NOT NULL,
    import_date date,
    total_price numeric,
    CONSTRAINT bill_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.import
    OWNER to postgres;
```
```sql
CREATE TABLE IF NOT EXISTS public.import_detail
(
    import_id integer NOT NULL,
    medicine_id integer NOT NULL,
    amount integer NOT NULL
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.import_detail
    OWNER to postgres;
```
```sql
CREATE TABLE IF NOT EXISTS public.medicine
(
    id integer NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    type_of_medicine text COLLATE pg_catalog."default",
    producer text COLLATE pg_catalog."default",
    price_per_unit numeric NOT NULL,
    amount integer,
    CONSTRAINT medicine_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.medicine
    OWNER to postgres;
```
```sql
CREATE TABLE IF NOT EXISTS public.patient
(
    patient_id integer NOT NULL,
    patient_full_name text COLLATE pg_catalog."default" NOT NULL,
    address text COLLATE pg_catalog."default",
    email text COLLATE pg_catalog."default",
    phone_number text COLLATE pg_catalog."default",
    gender text COLLATE pg_catalog."default",
    age integer,
    CONSTRAINT "Patient_pkey" PRIMARY KEY (patient_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.patient
    OWNER to postgres;
```
```sql
CREATE TABLE IF NOT EXISTS public.prescription_bill
(
    id integer NOT NULL,
    date_time timestamp without time zone,
    total_price numeric NOT NULL,
    patient_name text COLLATE pg_catalog."default" NOT NULL,
    created_by text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT prescription_bill_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.prescription_bill
    OWNER to postgres;
```
```sql
CREATE TABLE IF NOT EXISTS public.prescription_bill_detail
(
    prescription_id integer NOT NULL,
    medicine_id integer NOT NULL,
    amount integer NOT NULL
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.prescription_bill_detail
    OWNER to postgres;
```
```sql
CREATE TABLE IF NOT EXISTS public.salary_payment
(
    id integer NOT NULL,
    date date NOT NULL,
    employee_id integer NOT NULL,
    CONSTRAINT salary_payment_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.salary_payment
    OWNER to postgres;
```
```sql
CREATE TABLE IF NOT EXISTS public.service
(
    id integer NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    price numeric NOT NULL,
    CONSTRAINT service_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.service
    OWNER to postgres;
```
```sql
CREATE TABLE IF NOT EXISTS public.service_bill
(
    id integer NOT NULL,
    date_time timestamp without time zone NOT NULL,
    total_price numeric NOT NULL,
    patient_name text COLLATE pg_catalog."default" NOT NULL,
    created_by text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT service_bill_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.service_bill
    OWNER to postgres;
```
```sql
CREATE TABLE IF NOT EXISTS public.service_bill_detail
(
    service_bill_id integer NOT NULL,
    service_id integer NOT NULL
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.service_bill_detail
    OWNER to postgres;
```
- Tải PostgreSQL JDBC tại https://jdbc.postgresql.org/ (nếu chưa tải) 
- Tạo đường dẫn tới JDBC tại Service -> Databases -> New Connection...
- Thêm file postgesql.jar vào Libraries
- ![image](https://user-images.githubusercontent.com/84220651/174217051-3947f032-88ad-431f-8328-e19a8c068b69.png)
