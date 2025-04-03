CREATE TABLE department (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(60) DEFAULT NULL,
  PRIMARY KEY (Id)
);

CREATE TABLE seller (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(60) NOT NULL,
  Email varchar(100) NOT NULL,
  BirthDate datetime NOT NULL,
  BaseSalary double NOT NULL,
  DepartmentId int(11) NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (DepartmentId) REFERENCES department (id)
);

INSERT INTO department (Name) VALUES 
  ('Factory'),
  ('Culinary'),
  ('Fashion'),
  ('Music');

INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES 
  ('Bob Steve','bob@gmail.com','1998-04-21 00:00:00',1000,1),
  ('Maria Alexandra','maria@gmail.com','1979-12-31 00:00:00',3500,2),
  ('Bruno Miranda','bruno@gmail.com','1988-01-15 00:00:00',2200,1),
  ('Mariana Linda','mariana@gmail.com','1993-11-30 00:00:00',3000,4),
  ('Ronaldo Silva','ronaldo@gmail.com','2000-01-09 00:00:00',4000,3),
  ('Alex Pink','bob@gmail.com','1997-03-04 00:00:00',3000,2);
