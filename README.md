# Audio Note Taker Server
 
 Introduction:
 The repo holds the code for the Audio note taker application. The server is implemented using Java, Spring boot and Postgres.  
 
 Features Include: 
 - CRUD operations on Users, Audio Recordings and Tags
 - Basic Authentication 
 - JWT token Creation and Authentication
 - Storage of user, audio recording and tag information via a Postgres Database
 - Storage of Audio files via Local Storage 
 
 Src Folders:
 - AudioRecording: Holds controllers and services which handles Audio information and audio files
 - Config: Holds configuration information for web security and general bean configuration 
 - DAOS: Holds classes to model tables in the database
 - DataStroage: Holds interfaces and implementation of file storage providers  
 - JWT: Holds classes for JWT creation
 - Repository: Holds base repository classes for repositories
 - Tag: Holds services that handles Tags
 - User: Holds controllers and services which handles Users
 - Utils: Holds general utility classes used by other classes
 - UtilServices: Holds general utility services used by other services
 
 Authentication:
 All endpoints can be authenticated against using Basic Authentication and JWT authentication. JWT token can be generated using the /token endpoint. 
 
 
 Features Currently being worked on:
 - Using a cloud-based solution for storage of audio files
 - Using a Speech to Text cloud service to allow users to translate their audio recording to text
