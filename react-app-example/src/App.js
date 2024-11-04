import React, { useState } from 'react';
import axios from 'axios';
import './App.css';

function App() {
  const [id, setId] = useState('');
  const [eventName, setEventName] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('/api/events', {
        id: id,
        eventName: eventName
      });
      console.log('Success:', response.data);
      // 성공 후 폼 초기화
      setId('');
      setEventName('');
      alert('이벤트가 성공적으로 생성되었습니다!');
    } catch (error) {
      console.error('Error submitting form:', error);
      alert('이벤트 생성 중 오류가 발생했습니다.');
    }
  };

  return (
    <div className="App">
        <form onSubmit={handleSubmit}>
          <div>
            <label htmlFor="id">ID:</label>
            <input
              type="text"
              id="id"
              value={id}
              onChange={(e) => setId(e.target.value)}
            />
          </div>
          <div>
            <label htmlFor="eventName">Event Name:</label>
            <input
              type="text"
              id="eventName"
              value={eventName}
              onChange={(e) => setEventName(e.target.value)}
            />
          </div>
          <button type="submit">Submit</button>
        </form>
    </div>
  );
}

export default App;