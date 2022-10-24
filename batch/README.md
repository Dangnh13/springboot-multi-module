# point-management-sys batch job

### How to create a Cron Job:
To create a cron job, in terminal, type `crontab -e` to edit the cron job. Review following examples :
example:
```shell script
* * * * * java -jar JAR_FILE_LOCATION --spring.profiles.active=ACTIVE_PROFILE --AGRUMENTS=VALUE
```
 
### Run jobs on environments:

#### 1. JOB0001  
*Cron 02:00 am every day* 
* Develop environment
    ```shell script
    0 2 * * * java -jar /batch/target/batch-0.0.1-SNAPSHOT.jar --spring.profiles.active=development --batch_id=JOB0001 --LOG_PATH=/home/nhdang/app_log/batch/job0001 --username=MyUsername
    ```
* Staging environment
    ```shell script
    0 2 * * * java -jar /batch/target/batch-0.0.1-SNAPSHOT.jar --spring.profiles.active=staging --batch_id=JOB0001 --LOG_PATH=/home/nhdang/app_log/batch/job0001 --username=MyUsername --MYSQL_HOST={MYSQL_HOST}  --MYSQL_PORT={MYSQL_PORT}  --MYSQL_DB={DB_NAME}  --MYSQL_USERNAME={MYSQL_USERNAME} --MYSQL_PASSWORD={MYSQL_PASSWORD}
    ```

 ### Note for testing
 ##### Setting date time manual
 ```shell script
    timedatectl set-ntp false
    timedatectl set-time "2021-02-24 14:59:00"
```
#### Update time automatic
```shell script
  timedatectl set-ntp true
```