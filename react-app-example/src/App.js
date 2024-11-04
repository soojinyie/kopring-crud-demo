import React, { useState } from 'react';
import logo from './logo.svg';
import './App.css';

function App() {
  const [id, setId] = useState('');
  const [eventName, setEventName] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Submitted:', { id, eventName });
    // 여기에 서버로 데이터를 보내는 로직을 추가할 수 있습니다.
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