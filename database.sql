-- Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS furcare;
USE furcare;

-- Drop existing tables if they exist
DROP TABLE IF EXISTS donations;
DROP TABLE IF EXISTS contact_messages;
DROP TABLE IF EXISTS vet_requests;
DROP TABLE IF EXISTS volunteers;
DROP TABLE IF EXISTS veterinarians;
DROP TABLE IF EXISTS dogs;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_contributions;

-- Create tables
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone_number VARCHAR(20) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE dogs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    breed VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    gender ENUM('male', 'female') NOT NULL,
    location VARCHAR(255) NOT NULL,
    contact VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE veterinarians (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    gender ENUM('male', 'female', 'other') NOT NULL,
    address TEXT NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    qualification ENUM('bachelor', 'master', 'phd', 'diploma') NOT NULL,
    experience INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE volunteers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    gender ENUM('male', 'female', 'other') NOT NULL,
    address TEXT NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    interest TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE vet_requests (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address TEXT NOT NULL,
    number_of_dogs INT NOT NULL,
    examination_type ENUM('routine', 'immediate') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE contact_messages (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    message TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE donations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    donor_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    location VARCHAR(255) NOT NULL,
    usage_type ENUM('food', 'shelter', 'healthcare', 'accessories') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Verify tables were created
SHOW TABLES;

-- View all users
SELECT * FROM users;

-- View all dogs available for adoption
SELECT * FROM dogs;

-- View all veterinarian applications
SELECT * FROM veterinarians;

-- View all volunteer applications
SELECT * FROM volunteers;

-- View all vet examination requests
SELECT * FROM vet_requests;

-- View all contact messages
SELECT * FROM contact_messages;

-- View all donations
SELECT * FROM donations;

-- View users
SELECT * FROM users;

-- View dogs
SELECT * FROM dogs;

-- View veterinarians
SELECT * FROM veterinarians;

-- View volunteers
SELECT * FROM volunteers;

-- View vet requests
SELECT * FROM vet_requests;

-- View contact messages
SELECT * FROM contact_messages;

-- View donations
SELECT * FROM donations; 