CREATE TABLE MEMBER (
    MEMBER_ID VARCHAR(255) NOT NULL,
    TEAM_ID VARCHAR(255),
    USERNAME VARCHAR(255),
    PRIMARY KEY (MEMBER_ID)
);

CREATE TABLE TEAM (
    TEAM_ID VARCHAR(255) NOT NULL,
    NAME VARCHAR(255),
    PRIMARY KEY(TEAM_ID)
);

ALTER TABLE MEMBER ADD CONSTRAINT FK_MEMBER_TEAM
    FOREIGN KEY (TEAM_ID)
    REFERENCES  TEAM;


INSERT INTO TEAM(TEAM_ID, NAME) VALUES ('team1', '팀1');
INSERT INTO MEMBER(MEMBER_ID, TEAM_ID, USERNAME) VALUES ('member1' ,'team1', '회원1');
INSERT INTO MEMBER(MEMBER_ID, TEAM_ID, USERNAME) VALUES ('member2' ,'team1', '회원2');
