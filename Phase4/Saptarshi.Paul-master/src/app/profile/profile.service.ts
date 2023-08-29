import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  //baseUrl = environment.baseUrl;

  constructor(
    private http: HttpClient
  ) { }

 
  about2 = `Python for data science tasks, such as working with data structures, analyzing and visualizing data, and building machine learning models.
  MySQL databases using PHP, executing queries, and retrieving and processing the results. I have also worked with database normalization and optimization techniques to improve the performance of the applications.`

  about = "Recent B.Tech in Electrical Engineering graduate with a certification in Python programming from NPTEL (IIT MADRAS-2021). Strong academic background and hands-on experience in electrical design, power systems, control systems, and data analysis. Proficient in using industry-standard software such as AutoCAD, MATLAB, Simulink, and Python. Seeking positions in engineering industry with an emphasis on data analysis and automation to apply my knowledge and skills while continuing to learn and grow."
  resumeurl = "https://docs.google.com/document/d/1tZAxQvQkvuWhemmHKfOgX5vUgMAhqYHMlyqlG9BlIB8/edit?usp=sharing"

  skillsData: any = [
    {
        'id': '1',
        'skill': 'Postman, VS Code, Eclipse',
        'progress': '85%'
      },
      {
        'id': '2',
        'skill': 'NODE JS',
        'progress': '80%'
      },
      {
        'id': '3',
        'skill': 'JAVASCRIPT',
        'progress': '80%'
      },
      {
        'id': '4',
        'skill': 'SQL , MYSQL',
        'progress': '75%'
      },
      {
        'id': '5',
        'skill': 'JAVA',
        'progress': '75%'
      },
      {
        'id': '6',
        'skill': 'PYTHON',
        'progress': '70%'
      }
  ];


  educationData: any = [
    {
      'id': '1',
      'from_to_year': '2019 - 2022',
      'education': 'Bachelor\'s Degree',
      'stream': 'Bachelor of Technology',
      'info': `Heritage Institute of Technology is MAKAUT Affiliated and ranks 2nd in Kolkata.
Completed B.Tech in Electrical Engineering with 7.71 DGPA.`,
      'institution': 'HERITAGE INSTITUTE OF TECHNOLOGY'
    },
    {
      'id': '2',
      'from_to_year': '2016 - 2019',
      'education': 'Diploma',
      'stream': 'Diploma',
      'institution': 'CONTAI POLYTECHNIC',
      'info': `Contai Polytechnic is a Government body and WBSCTE Affiliated.
Completed my Diploma in Electrical Engineering with 7.1 OGPA.`
    },
    {
      'id': '3',
      'from_to_year': '2012 - 2013',
      'education': 'Secondary  School',
      'stream': 'Science and Mathematics',
      'institution': 'GYANDEEEP VIDHYALAYA,AHMEDABAD',
      'info': `The Secondary aims at Maths , English , Science, Social Science, Hindi.
Completed my Secondary school with 7.6 CGPA`
    }
  ];
  exprienceData: any = [
    {
      id: 1,
      company: 'Mphasis',
      location: 'Pune',
      timeline: 'May 2023 to Present',
      role: 'Associate Software Developer',
      work: 'Working as a full stack java developer. Responsible for handling Web Development and Developing source codes.'

    },


  ]

  extraCircularInfo: any = [
    
    {
      id:1,
      title: 'Github',
      description: '',
      img: 'assets/images/Saptarshi_github.png',
      url: 'https://github.com/meRishi07/'
    },
   
  ]
  // contactus(data: any): Observable<any> {
  //   return this.http.post(this.baseUrl + 'contact', data);
  // }

  skills(): Observable<any> {
    // return this.http.get(this.baseUrl + 'skills');
    return this.skillsData;
  }

  education(): Observable<any> {
    // return this.http.get(this.baseUrl + 'education');
    return this.educationData;
  }

  exprience(): Observable<any> {
    // return this.http.get(this.baseUrl + 'exprience');
    return this.exprienceData;
  }

  extraCircular(): Observable<any> {
    // return this.http.get(this.baseUrl + 'exprience');
    return this.extraCircularInfo;
  }
}