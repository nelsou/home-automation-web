DDL_AUTO=validate
JDBC_URL=jdbc:postgresql://localhost:5432/home
JDBC_USER=nelson
JDBC_PASSWORD=home


$ sudo su - postgres
$> createuser --interactive
$> Enter name of role to add: nelson
$> Shall the new role be a superuser? (y/n) y
$> postgres@ubuntu:~$ createdb -O nelson home
$ psql -d home
$> ALTER USER nelson WITH PASSWORD 'sql';