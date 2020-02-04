--Exam1_1.sql

CREATE DATABASE DB05;
GO

USE DB05;
GO

CREATE TABLE Employee
(
	cid VARCHAR(10) PRIMARY KEY NOT NULL,
	cname NVARCHAR(50) NOT NULL
);
GO

CREATE TABLE Substitute
(
	cid VARCHAR(10),
	sdate VARCHAR(8),
	edate VARCHAR(8),
	stime VARCHAR(4),
	etime VARCHAR(4),
	FOREIGN KEY(cid) REFERENCES Employee(cid)
);
GO

INSERT INTO Employee(cid, cname) VALUES('01', '桐谷和人');
INSERT INTO Employee(cid, cname) VALUES('02', '尤吉歐');
INSERT INTO Employee(cid, cname) VALUES('03', '尤吉歐·Synthesis·Thirty-two');
INSERT INTO Employee(cid, cname) VALUES('04', '愛麗絲·Synthesis·Thirty');
INSERT INTO Employee(cid, cname) VALUES('05', '亞絲娜');
INSERT INTO Employee(cid, cname) VALUES('06', '賽魯卡·滋貝魯庫');
INSERT INTO Employee(cid, cname) VALUES('07', '羅妮耶·亞拉貝爾');
INSERT INTO Employee(cid, cname) VALUES('08', '蒂潔·修特利尼');
INSERT INTO Employee(cid, cname) VALUES('09', '卡迪納爾·Cardinal');
INSERT INTO Employee(cid, cname) VALUES('10', '阿多米尼斯多雷特·Administrator');
GO
