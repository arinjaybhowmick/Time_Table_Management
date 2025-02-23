"use client";

import Steps from "@/components/steps";
import { useState } from "react";
import { Providers } from "../providers";
import Days from "@/app/steps/days";
import Periods from "../steps/periods";
import Upload from "../steps/upload";
import ChatAI from "../steps/chatai";
import Generate from "../steps/generate";

export default function StartLayout({
  children,
}: {
  children: React.ReactNode;
}) {

  const [currentStep, setCurrentStep] = useState(0);

  const stepComponents = [
    <Days />,
    <Periods />,
    <Upload />,
    <ChatAI />,
    <Generate />,
  ];

  return (

    <section className="flex flex-row items-start py-20 md:py-10">
      <div className="max-w-lg text-center justify-center border-r-2 border-black pr-4">
        <Steps
          steps={[
            { title: "Select Days", },
            { title: "Decide Periods", },
            { title: "Upload Data", },
            { title: "Chat with AI", },
            { title: "Generate Timetable", },
          ]}
          currentStep={currentStep}
          onStepChange={setCurrentStep}
        />
      </div>

      <div className="flex-1 max-w-lg text-center pl-4">
        <Providers themeProps={{ attribute: "class", defaultTheme: "dark" }}>
          <div className="relative flex flex-col">
            <main className="container mx-auto flex-grow">
              {stepComponents[currentStep]}
            </main>
          </div>
        </Providers>
      </div>
    </section>
  );
}
