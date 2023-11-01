CREATE TABLE student (
    id SERIAL PRIMARY KEY,
    lastName CHARACTER VARYING(30) CHECK(lastName !='') NOT NULL,
	firstName CHARACTER VARYING(30) CHECK(firstName !='') NOT NULL,
    age INTEGER CHECK(age > 4 AND age < 18) NOT NULL,	
    classNumber INT CHECK(classNumber > 0 AND classNumber < 13) NOT NULL
);

CREATE TABLE subject (
    id SERIAL PRIMARY KEY,
    subjectName CHARACTER VARYING(30) CHECK(subjectName !='') UNIQUE NOT NULL
);

CREATE TABLE assessment (
    idStudent INT,
    idSubject INT,
    assessment INTEGER CHECK(assessment > 0 AND assessment < 6) NOT NULL,
    FOREIGN KEY (idStudent) REFERENCES student(Id),
    FOREIGN KEY (idSubject) REFERENCES subject(Id),
	UNIQUE(idStudent, idSubject)
);

INSERT INTO subject (subjectName)
	 VALUES ('physics'),
			('mathematics'),
			('russian language'),
			('literature'),
			('geometry'),
			('informatics');