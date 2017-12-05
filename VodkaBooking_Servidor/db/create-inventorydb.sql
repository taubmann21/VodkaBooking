/* DELETE 'vodkabookingdb' database*/
DROP SCHEMA IF EXISTS vodkabookingdb;
/* DELETE USER 'sd' AT LOCAL SERVER*/


/* CREATE 'vodkabookingdb' DATABASE */
CREATE SCHEMA vodkabookingdb;
/* CREATE THE USER 'sd' AT LOCAL SERVER WITH PASSWORD 'sd' */

/* GRANT FULL ACCESS TO THE DATABASE FOR THE USER 'sd' AT LOCAL SERVER*/
GRANT ALL ON easybookingdb.* TO 'sd'@'%';
