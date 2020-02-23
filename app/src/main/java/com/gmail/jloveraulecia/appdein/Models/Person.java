package com.gmail.jloveraulecia.appdein.Models;

import java.io.Serializable;

public class Person implements Serializable {
    private Integer id=null;
    private String user ="";
    private String email ="";
    private String password="";
    private int telef1=0;
    private int telef2=0;
    private String image = "/9j/4AAQSkZJRgABAQEAYABgAAD//gA7Q1JFQVRPUjogZ2QtanBlZyB2MS4wICh1c2luZyBJSkcgSlBFRyB2NjIpLCBxdWFsaXR5ID0gNzUK/9sAQwAIBgYHBgUIBwcHCQkICgwUDQwLCwwZEhMPFB0aHx4dGhwcICQuJyAiLCMcHCg3KSwwMTQ0NB8nOT04MjwuMzQy/9sAQwEJCQkMCwwYDQ0YMiEcITIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIy/8AAEQgDVwNXAwEiAAIRAQMRAf/EAB8AAAEFAQEBAQEBAAAAAAAAAAABAgMEBQYHCAkKC//EALUQAAIBAwMCBAMFBQQEAAABfQECAwAEEQUSITFBBhNRYQcicRQygZGhCCNCscEVUtHwJDNicoIJChYXGBkaJSYnKCkqNDU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6g4SFhoeIiYqSk5SVlpeYmZqio6Slpqeoqaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2drh4uPk5ebn6Onq8fLz9PX29/j5+v/EAB8BAAMBAQEBAQEBAQEAAAAAAAABAgMEBQYHCAkKC//EALURAAIBAgQEAwQHBQQEAAECdwABAgMRBAUhMQYSQVEHYXETIjKBCBRCkaGxwQkjM1LwFWJy0QoWJDThJfEXGBkaJicoKSo1Njc4OTpDREVGR0hJSlNUVVZXWFlaY2RlZmdoaWpzdHV2d3h5eoKDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uLj5OXm5+jp6vLz9PX29/j5+v/aAAwDAQACEQMRAD8A9NooorqMwooooAKKKKACiiigAooooAKKKKACiiigQUUUUDCiiigAooooAKKKKBBRRRQAUUUUDCiiigQUUUUDCiiigQUUUUAFFFFABRRRQMKKKKACiiigQUUUUDCiiigQUUUUDCiiigQUUUUDCiiigAooFBoAKBRSigBKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigBKWiigAooooAKKKKACiiigAooooEFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQMKKKKACiikoAM0oNJRQAtFFFABRSUUALRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQIKKKKBhRRRQAUUUUAFFFFABRRRQAUUUUAFFFFAgooooGFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFJmgBetJS5oJFACZxTSS1P4NISo7UrgC8dadwaj3CkyaLgSHgUh5FIc7RTh92mAicUZyaBQAQaAFooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACilwKCKAEoprHFKMmgBaKQnFABwT2p2AWik3LjrzTCzCkBJRkY5xUSmRzhRk1MLK4c5KUmwsRk+9N2sema0YNLZvvKavx6XGOoNS5DsYSQu5xzUy6fIe7flXQx2ESHIBz71OI1XpUOaCxzqacw9fyqVdPY+v5Vv7QByKqXFysOdpFCkFjDuIDGKrKeMVNc3bTOwOOvpUCYzzWqEPAoJoc4Hy01Qc5NUA6iiikAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUYoozQIORSZpaKBigBgfambsGhjjpQBu7UAKSCKYZDjaO9TR2jyH+L8q1bfTBjJP6VLnYdjGitpJMYNaNvppcfMBW1FbJEuOD+FTAL2ArNzHYzYdLSNgdq1eEMY/hFPyc9KfUOQ7DAqjtTuPSjFFS2MMUnelPSgdKQDZc+W2PSub1GR1dvmPaul6jFZ1/ZiTJH8q0ixM5+IBiSac6c8U2S3kjkbAbH0pEY5wf1raLJHdKceQKbIR2oQ5FUIXFFKaaaAClptLQAtFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQIKKKKBhRRRQAUUUUAFFFFIAooopgFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUhoAWkzRS7c0AA5FCjcDjtSE7aVWCg4pMQEY+tNOR1pGfLZpY4nlbFFxoEV5GwozWnaae7AMymrFrp2zBIHatSNAi4qJTKSIYbZYwBjtVgjA460YyaXNYtlWGgFl+YYNAUqakopANNHPenUlACYopaSiwwPSgdKUUtFhDcU0jd1qSkIpoCjPZq4OAc1g3VpLE+duBXV7arXFqJQeO1WpEnLAg8HrS4wMir11p5jywxWeSVYg9K0UhCg04A0BQRmgt2qriDIFFAGaDTASlxSU6gBKKDRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQIKKKKBhRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRSHigBcUhbFGc0bc0AJjNIfl49ad0oETTSKAM0mND7a3MzjGa6C0slRFJ647imafZ+VGCQcitEccVlJjSEGBxSnpSYGaXPasrlCDg0vWg0CmMWloooEFFFJQAtJRmjmgAApaSjNAC0UUUgEpM9qM80EUwI5YlkXGKxr+w4yoPX0rcBproGBBqk7EtHHMTG20g1ICCue9XdRtNp3BTwKzI2IbbWqZJLnBpxprHGPenVSAb3paKDTAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKBBRRRQMKKKKACiiigAooooAKKKKACiiigQUUUUDCiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAClXGaSgUAJjrSITupynrSAc5oASQ+laOlwZOWGeazPvS4966exh2xg1lNlIuKoA4pcUGlrIoSjFLijFABRRiloAKKKKACiiigBKWiigApKWigAooooAb3paKMUAFFFHSgCnd24eNsjPFc1cxiOdsDFddJzGRXOalERIxAq4sllPgoKUUxfSnVsiQNLTTRmmAopaQUtABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUCCiiigAooooAKKKKBhRRRQAUUUUAFFFFABRRRQAUUUUCCiiigYUUUUAFFFFABRRRQAUUUUCCiiigYUUUUAFFFFABRRRTAKKKQ0gDoDSg/ITSbeKQnamKAC3G6c111uMRD6VydlzcGuthGIx9KyqFId/FTj0pMc0pGayKAdKWkpaACiiigAooooAKKKKACiiigAooooAKKKKACiiigApKWkNACEcVk6nGAjGtc1naku6BqqJLObVv3jCnkUxRtmfPrUh5rZEjaKXpSDrVgOxRRmikAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQIKKKKACiiigYUUUUAFFFFABRRRQAUUUUCCiiigYUUUUAFFFFABRRRQAUUUUCCiiigYUUUUAFFFFABRRRQAUUUUAFIaWigBR0pjD5TT+1NJ+WgCbT0/fGuqT7g+lcxp5/fn6V06/cH0rGoVEdS0lLWZQUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABSUtJQAGqGof6hqvmqOof8e7U4iZzJ/17/WnCm9Z3+tSVuiBppBTqTFUADpS0CigAoopM0ALRSZpaACijFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUCCiiigAooooAKKKKBhRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQIKKKKBhRRRQAUUUUAFFFFABRRRRYAzxTT92lFD/cNAE+n/wCvNdSn3B9K5XTuJzXUx/cFY1Coj6WmmlFZlC0UUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABSUtJQAlUtR/492q73qlqP8Ax7tVREzmR/rn+tSVH/y3f61J2raJAhoo70tUADpQaSigBDRS0UAJS0UUALSGiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigQUUUUDCiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACgUUUwEFDcqaUCkP3TSAfYnE5rrIvuD6VyNocTmuth/1a/SsplIkNAoorIoWikFLQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFJ3oADWfqRxbtWgazdT/1LVUSWc4P9e/1qU1Cv+uepq2RIlL2pKXtVAJRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQIKKKKBhRRRQAUUUUAFFFFABRRRQAUUUUCCiiigYUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUDmgAJxSclKCKHbalJsBLcETZrroDmJfpXI27ZkrrLf8A1Y+lZTKRMTSjpSNzSgVmUApaKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigApDS00igA61mam37ph9K0xwKxtWb5X/CnElmIOJWPWpCeKZEcu2ace9bxJAGlJpgPNPFUACiiigAooooAKKKKACiiigAooooAKKKKACkzS0UAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUCCiiigYUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUZxRSEZoABzQV3nApQPlNNgf9+AalgaFpYE4PFb6LtQD2qC0x5K/SrWOKxkykAOaWk6Ud6koUUtFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUlLSUANNUL21Myt05q+1GAR0px0EzlpbUxMelQEc4rV1Q7ScDvWSDzzW0SGBGKM044IptWA6igUUAFFFFABRRRQAUUUUAFFFFAAaTNLSUALRRS0AJRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUCCiiigAooooGFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFAODRRQAgPBpsYxcA04CkHyyZqJAdPZ8wr9KuVm6dJuQD2rSPSsZFIKKbThUlBS0UUwCiiigAooooAKKKKACiiigAooooAKKKKACiiigApDS0h6UAJ2ppOKUmmyfdJoQmYWrNkj/erMA4q5qb5f/gVVRW0SGGOKTFPptaCFooooGFFFFABRRRQAUUUUAFFFFACUUUUCFzRSUtAwooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigQUUUUDCiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACgdaKKADPNRynHNPOB0psg+TJqWBsaQ+Tj/AGa2+orA0Zv3hHtW8pOKymVEcBS00H5sUpzUFC0Ug6UtABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRSUUALTScUtIeetAARUM7bYjUuarXpxAaaRLOcvW3Sn/eqJTSzcytn1oUDFbpEi0UHGaMVQgPWikHNLQMKKKKACiiigAooooAKKKKAEopaO1AhBS0UUDCiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKBBRRRQMKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKQnA4oAQrzSyYMZFO7U1eeKVgLOmzeTLz6YrpYpA6Ag1x0mUORW1pl0XXBI64rOaKRs/xU49KQHIoNZFCjpS0naloAKKKKACiiigAooooAKKKKACiiigAooooAKKTNGaAFprcYpc0h5oATOBk1nX8w8tgDVi9lMUZx6VztxctI5FXBEsgkbMjfWngcU1VBOTTyRW6JY0ilzxRjNJjmgQtFHeigYUUUUAFFFFABRRRQAUUUUAIaWiigAozRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFAgooooAKKKKBhRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAvGKbuwaXNNNACSAyDirGmSeXJhu7VEBxTYDslH1qZIaOwjbcme1OyDxVayk3RAVZHWsHuWKKWkopALRRSUALRRRQAUUUUAFFFFABRRSUALRRRQA3HNGKWigBtGRS9aawxzQBS1Nh5bZ9K5z5TJkVqapccEZPK1kRnJBraKIbJc46U0g5pxpcitUIQcdaM80uKQjFJiA4opBS0DCiiigAooooAKKKKACiiigApDS0UAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFAgooooGFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFGM0UZxQAYoPFGc0uOKAGZoBwwNDDmhlO3NJgjd0yYFVFah5Fczps2JlGa6SNt0YNYSRSZIOlFJS1JQUUUnekA6iiimAUUUUAFFFFABRRRQAUUUlABSZpaTFAC0yRgqHJ7U6qd8+2OmlcTMC/ffL+FQIuFpZAWkpM44rZIkGJpBmn4yKbkVoIdRSbqUHNIQUUUUDCiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooEFFFFABRRRQMKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKBRQKAAUhzupR1pG+9QArdBSMcilb7opFGaACElJAc10llNvjUE9vWuaIxVyyuTG+OOlRJDR0oBpwqOJ96A+1SVgyxaTvSUopALRRRTAKKKKACiiigBDQKDQKAFpDS0h60gEzS9qQ0CmhDSwVMmsHVLokgAnqe9aV7LsQ9Otc1Mxllb61pFCuIGyadkUKmOtLt5rVEhTad0opgApaKKACiiigAooooAKKKKACjNIaKAFopBS0AFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQIKKKKBhRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABQOtFFAAOtIfvUopMc5oAVvuimrkg048jFCfdNADQecUIcSE0Y+fikH36lgjp7F90f4CrYNUNNB8s/hV8DFYSLQtLSUtIYtFFFABRRRQAUUUUAJSDrSmigAFBooNJgJRnNIaAMU0JmTqhwrfUVhL/AKxq3dW+4x96wk++a2iSSHpQrZOKXIPFN245rQQOO9Lil6ikzQAUUZozQAUUUUAFFFFABRRRQAhoooxQIBS0UUDCiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKVehFJR2NCQB3pqj56cDTVP7ypkho6PTuEP4Vodqoaf9w/QVfrBlIQUtJ3paQxaKKKACiiigAooooASiiigBaQ0tFADTRSmkNCEzL1Vcxt9RXPgYdq6TUxmFvqK50jDmtYEMcKDQKDWoCikoooAKKKKEAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQIKKKKACiiigYUUUUAFFFFA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Y65q8l3yEe9dFeHEP41ylwcynHrWsCAIK8inI27rSc9DTipC5FbCEEQbNMZCp4zTgXHQ0uSetKw7jRvAyM0C4lU07J/CjaposFyWO9deTVuPVSMcis4oDTfKB7UnELmyus9MlatR6mjkDctc6IATTirxHg1PIgudP9rQDJYVm3+oblwpB4rKa4lx96oxuY80coriDfK2WqYIIxmgYC8dablifm6VSQDt240oGDScDpSc1YD6Q0nNFIBDQelLSGgAFBoFBFAC0UHtRQAUUUUAFFFFABRRRQAUUUUAFN70tJQAtGM0UE4oAQnFA5pOtPAxQAADpTG4OadznNIRmlYCaK9aMcZqT+0XZsZaqwjFNKYPFLlHctNeOe5qFp3Pc1HzSijlC4F3Pc1GMk1MKQjHNOwrhjApuead1GKTbTAeegppPFLikoAQdaGGadijHFNgJaPsnUe9dXandbqfauRi4uFrq7E5tk+lYTKRZA60DpRmisyhRS0lLSAKKKKYBRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABSZpaSgBgHJpxHNA70ZyKAKl+wEP41zMgzIT71t6pLtUj3FYp5Oa2giBrdaUt8lKwpCMjFaCFpKXHFFIQmKKKOlAAQaTmnZozQMQEikZiWp+4GmsMtQIUKCKNuOlByFFCd6YCUuM0h605aAE20U+mnpQMSiiigBDRQaKAFooooAKKKKACiiigAooooAKKKKBBRRSd6Bi02l7U3vQA73pOtFO7UAIOKcOabnml7UAKelJiiigQufejr1pKKBhx6Uvy0lFAg4pGpaKBjRkU7NFGKAF7U3vS0lACnpQvSiigCI/LMprotPm/cqM9q59+taulNyB/s1nJDRujpmgdKP4RSisSkLS0UUDCiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAoopKADtTAeDSt2oPFAmc/q7/Ow96oL9yrmsHMzY9RVFOVreOxIuaXIpmOadirELmiiigAozRSUALxRiiigBuOaXBzS0UAKxG0UinrSUdKAFIoBxRRQAZozRSUALRRRQAhooNFAC0UUUAFFFFABRRRQAUUUUAFFFFABSUtFACUh60/tTT1oAB0o7UYo7UAJml7UmOadjigAFFA6UtACYopaKAEooooAKKKKACiiigAooooAKKKKAI5OlX9LfEg/3apMMqamsW2y/hUyGjq05QfSnVFA2Yx9BUtYPcsWiiikAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFJS0lACHrUc7bYyfQVLVW+bFu59qa3Ezn9QffM1V16UrtvlNIBzWyIFNJmlPSm1YDqKKKACiiigAooooAKKKKACiiigAooooAKKKSgBaKKKAENFBooAWiiigAooooAKKKKACiiigAooooAKKKKBC5ptFFAxRR2oooASnUUUAGKMUUUAJnmjOaKKBBRRRQAUUUUAFFFFAwooooAKKKKQCEYGKdA2yTOM8UUUMEdNaNuiB9hVlTmiisJFodRRRUjCiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigApO9FFACA1S1NsWkn+7RRTjuJnMRtmQnFPHzGiiuhbEMcRSZ2jOKKKYBRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAIaKKKAFooooAKKKKACiiigAooooA//9k=";


    public Person() {}


    public void setId(Integer id) {
        this.id = id;
    }

    public boolean setUser(String user) {
        if(user.isEmpty()){
            return false;
        }else {
            this.user = user;
            return true;
        }
    }

    public boolean setEmail(String email) {
        if(!email.contains("@")){
            return false;
        }else{
            this.email = email;
            return true;
        }
    }

    public boolean setPassword(String password) {
        if(password.length()<6){
            return false;
        }else{
            this.password = password;
            return true;
        }
    }


    public boolean setTelef1(int telef1) {
        String tel=""+telef1;
        if(tel.length()<9){
            return false;
        }else{
            this.telef1 = telef1;
            return true;
        }
    }


    public boolean setTelef2(int telef2) {
        String tel=""+telef2;
        if(tel.length()<9){
            return false;
        }else{
            this.telef2 = telef2;
            return true;
        }
    }


    public boolean setImage(String image) {
        if(image!=null){
            this.image = image;
            return true;
        }else{
            return false;
        }
    }

    public Integer getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getTelef1() {
        return telef1;
    }

    public int getTelef2() {
        return telef2;
    }

    public String getImage() {
        return image;
    }
}
