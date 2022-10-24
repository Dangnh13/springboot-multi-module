# point-management-sys schema migration management

Welcome!

This is an MyBatis Migration repository.  You can specify the repository
directory when running migrations using the --path=<repos-directory>
option.  The default path is the current working directory ("./").

The repository base directory contains three subdirectories as follows:

./drivers

Place your JDBC driver .jar or .zip files in this directory.  Upon running a
migration, the drivers will be dynamically loaded.

./environments

In the environments folder you will find .properties files that represent
your database instances.  By default a development.properties file is
created for you to configure your development time database properties.
You can also create test.properties and production.properties files.
The environment can be specified when running a migration by using
the --env=<environment> option (without the path or ".properties" part).

The default environment is "development".

Example:
```sh
$ mvn -Dmigration.env=production migration:status

```

./scripts

This directory contains your migration SQL files.  These are the files
that contain your DDL to both upgrade and downgrade your database
structure.  By default, the directory will contain the script to
create the changelog table, plus one empty "first" migration script.
To create a new migration script, use the "new" command.  To run
all pending migrations, use the "up" command.  To undo the last
migration applied, use the "down" command etc.

Command:
+ create the new script
```shell script
mvn migration:new -Dmigration.description=my_second_schema_migration
```

* apply migration to the database
    *  Local
    ```shell script
    $ mvn migration:up -Dmigration.env=local
    ```
    * development
    ```shell script
      $ mvn migration:up
    ```
  
    * staging
    ```shell script
    $ mvn migration:up -Dmigration.env=staging
    ```
      
    * production
    ```shell script
    $ mvn migration:up -Dmigration.env=production
    ```
  
* Revert migration to the database
    *  Local
    ```shell script
    $ mvn migration:down -Dmigration.env=local -Dmigration.down.steps=1
    ```
    * development
    ```shell script
    $ mvn migration:down -Dmigration.down.steps=1
    ```
    * staging
    ```shell script
    $ mvn migration:down -Dmigration.env=staging -Dmigration.down.steps=1
    ```
    
    * production
    ```shell script
    $ mvn migration:down -Dmigration.env=production -Dmigration.down.steps=1
    ```
* Check the current status of your database
    * Local
    ```shell script
    $ mvn migration:status -Dmigration.env=local
    ```
    * development
    ```shell script
    $ mvn migration:status
    ```
    * staging
    ```shell script
    $ mvn migration:status -Dmigration.env=staging
    ```
    * production
    ```shell script
    $ mvn migration:status -Dmigration.env=production 
    ```
 
 * Run pending
     * Local
     ```shell script
     $ mvn migration:pending -Dmigration.env=local
     ```
     * development
     ```shell script
     $ mvn migration:pending
     ```
     * staging
     ```shell script
     $ mvn migration:pending -Dmigration.env=staging
     ```
     * production
     ```shell script
     $ mvn migration:pending -Dmigration.env=production 
   
##### Note*: If database provider is MYSQL, let's set as bellow: 
```sh
send_full_script=false
```

For more information about commands and options, run the MyBatis
Migration script with the --help option.

Enjoy.
