DROP TABLE IF EXISTS Teams;
CREATE TABLE Teams(
    team VARCHAR(30),
    team_city VARCHAR(30),
    team_state VARCHAR(30),
    conference VARCHAR(30),
    division VARCHAR(30),
    arena_ID INT  NOT NULL,
	PRIMARY KEY(team),
	FOREIGN KEY(arena_ID) REFERENCES ARENA(arena_ID)
);

/*You must turn off Enable Foreign key checks when creating table   */

INSERT INTO Teams VALUES
('Los_Angeles_Lakers','Los Angles','California','Western','Pacific',112345),
('Golden_State_Warriors','San Fansisco','California','Western','Pacific',212245),
('Atlanta_Hawks','Atlanta','Georgia','Eastern','Atlantic',333345),
('Miami_Heat','Miami','Florida','Eastern','South East',442344),
('Dallas_Mavericks','Dallas','Texas','Western','South West',512555),
('Los_Angeles_Clippers','Los Angles','California','Western','Pacific',166366),
('Philadelphia_76ers','Philadelphia','Pennsylvania','Eastern','Atlantic',772345),
('Denver_Nuggets','Denver','Colorado','Western','North West',888845),
('Portland_Trail Blazers','Portland','Oregon','Western','North West',912345),
('Brooklyn_Nets','Brooklyn','New York','Eastern','Atlantic',102305),
('Phoenix_Suns','Phoenix','Arizona','Western','Pacific',112110),
('Milwaukee_Bucks','Milwaukee','Wisconsin','Eastern','Central',121210);

