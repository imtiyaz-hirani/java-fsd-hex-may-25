import { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { Chart } from 'primereact/chart';
import axios from "axios";

function Stats() {
    const [courses,] = useState(useSelector(state => state.courses.courses));
    const [chartData, setChartData] = useState({});
    const [chartOptions, setChartOptions] = useState({});
    const [titles, setTitles] = useState([]);
    const [enrolls, setEnrolls] = useState([]);
    useEffect(() => {
        const getStats = async () => {
            let response = await axios.get('http://localhost:8080/api/author/enroll/stats',
                { headers: { 'Authorization': 'Bearer ' + localStorage.getItem('token') } }
            )
            setTitles(response.data.courseTitles)
            setEnrolls(response.data.enrolls)

            const data = {
                labels: response?.data?.courseTitles,
                datasets: [
                    {
                        label: 'Course Enrollments',
                        data: response?.data?.enrolls,
                        backgroundColor: [
                            'rgba(255, 159, 64, 0.2)',
                            'rgba(75, 192, 192, 0.2)',
                            'rgba(54, 162, 235, 0.2)',
                            'rgba(153, 102, 255, 0.2)',
                            'rgba(20, 26, 27, 0.2)'
                        ],
                        borderColor: [
                            'rgb(255, 159, 64)',
                            'rgb(75, 192, 192)',
                            'rgb(54, 162, 235)',
                            'rgb(153, 102, 255)',
                            'rgb(56, 196, 142)'
                        ],
                        borderWidth: 1
                    }
                ]
            };
            const options = {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            };
            setChartData(data);
            setChartOptions(options);

        }
        getStats();
    }, [])
    return (
        <div>
            <h1>Stats</h1>

            <div className="col-lg-8 col-lg-offset-2" style={{ width: '80%' }}>
                <div className="card">
                    <div className="card-body">
                        <Chart type="bar" data={chartData} options={chartOptions} />
                    </div>
                </div>
                <h1 className="text-3xl font-bold mb-4">Fancy Toggle Sidebar Navigation</h1>
                {
                    courses.map((c, index) => (
                        <div key={index}>
                            <li>{c.title}</li>
                        </div>
                    ))
                }
                <p className="mb-4">Bacon ipsum dolor sit amet tri-tip shoulder tenderloin shankle. Bresaola tail pancetta ball tip doner meatloaf corned beef. Kevin pastrami tri-tip prosciutto ham hock pork belly bacon pork loin salami pork chop shank corned beef tenderloin meatball cow. Pork bresaola meatloaf tongue, landjaeger tail andouille strip steak tenderloin sausage chicken tri-tip. Pastrami tri-tip kielbasa sausage porchetta pig sirloin boudin rump meatball andouille chuck tenderloin biltong shank </p>
                <p className="mb-4">Pig meatloaf bresaola, spare ribs venison short loin rump pork loin drumstick jowl meatball brisket. Landjaeger chicken fatback pork loin doner sirloin cow short ribs hamburger shoulder salami pastrami. Pork swine beef ribs t-bone flank filet mignon, ground round tongue. Tri-tip cow turducken shank beef shoulder bresaola tongue flank leberkas ball tip.</p>
                <p className="mb-4">Filet mignon brisket pancetta fatback short ribs short loin prosciutto jowl turducken biltong kevin pork chop pork beef ribs bresaola. Tongue beef ribs pastrami boudin. Chicken bresaola kielbasa strip steak biltong. Corned beef pork loin cow pig short ribs boudin bacon pork belly chicken andouille. Filet mignon flank turkey tongue. Turkey ball tip kielbasa pastrami flank tri-tip t-bone kevin landjaeger capicola tail fatback pork loin beef jerky.</p>
                <p className="mb-4">Chicken ham hock shankle, strip steak ground round meatball pork belly jowl pancetta sausage spare ribs. Pork loin cow salami pork belly. Tri-tip pork loin sausage jerky prosciutto t-bone bresaola frankfurter sirloin pork chop ribeye corned beef chuck. Short loin hamburger tenderloin, landjaeger venison porchetta strip steak turducken pancetta beef cow leberkas sausage beef ribs. Shoulder ham jerky kielbasa. Pig doner short loin pork chop. Short ribs frankfurter rump meatloaf.</p>
                <p>Filet mignon biltong chuck pork belly, corned beef ground round ribeye short loin rump swine. Hamburger drumstick turkey, shank rump biltong pork loin jowl sausage chicken. Rump pork belly fatback ball tip swine doner pig. Salami jerky cow, boudin pork chop sausage tongue andouille turkey.</p>
            </div>
        </div>


    )
}

export default Stats;